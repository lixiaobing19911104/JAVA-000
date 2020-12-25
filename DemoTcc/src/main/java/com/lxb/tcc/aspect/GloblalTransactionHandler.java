package com.lxb.tcc.aspect;

import com.lxb.tcc.entity.TransactionInfo;
import com.lxb.tcc.enums.TransactionStatus;
import com.lxb.tcc.mappers.TransactionInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @author lixiaobing
 * @date 2020-12-25 15:25
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class GloblalTransactionHandler {

    private final TransactionInfoMapper transactionInfoMapper;

    public GloblalTransactionHandler(TransactionInfoMapper transactionInfoMapper) {
        this.transactionInfoMapper = transactionInfoMapper;
    }

    @Pointcut(value = "@annotation(com.lxb.tcc.annotation.TccTransaction)")
    public void globalTransaction() {
    }

    /**
     * 对全局事务进行拦截处理
     */
    @Around("globalTransaction()")
    public Object globalTransactionHandler(ProceedingJoinPoint point) throws Throwable {
        log.info("Global transaction handler");
        // 生成全局事务ID，放入threadLocal中
        String transactionId = createTransactionId();
        RootContext.set(transactionId);
        try {
            point.proceed();
        }catch (Throwable throwable) {
            // try 失败以后，在数据库中更新所有分支事务的状态
            log.info("global update transaction status to try failed");
            updateTransactionStatus(transactionId, TransactionStatus.TRY_FAILED);
            log.info("global update transaction status to try failed end");
            // 发送消息推动进入 cancel 阶段
            log.info(transactionId + " global transaction try failed, will rollback");
            sendTryMessage(transactionId);
            RootContext.remove();
            throw throwable;

        }
        // try 成功，在数据库中更新所有分支事务的状态
        log.info("global update transaction status to try success");
        updateTransactionStatus(transactionId, TransactionStatus.TRY_SUCCESS);
        log.info("global update transaction status to try success end");
        if (!sendTryMessage(transactionId)) {
            log.info(transactionId + " global transaction confirm failed, will cancel");
            updateTransactionStatus(transactionId, TransactionStatus.CONFIRM_FAILED);
            sendTryMessage(transactionId);
            RootContext.remove();
            return null;
        }

        updateTransactionStatus(transactionId, TransactionStatus.CONFIRM_SUCCESS);
        RootContext.remove();
        return null;
    }

    private boolean sendTryMessage(String transactionId) {
        log.info("send message to local TM to execute next step");
        String[]     slice        = transactionId.split(":");
        String       targetHost   = slice[0];
        String       targetPort   = slice[1];
        RestTemplate restTemplate = new RestTemplate();
        String       url          = "http://" + targetHost + ":" + targetPort + "/tm/tryNext?xid=" + transactionId;
        Boolean      response     = restTemplate.getForObject(url, boolean.class, new HashMap<>(0));
        if (response == null || !response) {
            log.info("try next step execute failed, please manual check");
            return false;
        } else {
            log.info("try next step execute success");
            return true;
        }

    }

    private String createTransactionId() throws UnknownHostException {
        String localAddress = InetAddress.getLocalHost().getHostAddress();
        String timeStamp    = String.valueOf(System.currentTimeMillis());
        return localAddress + ":8080:" + timeStamp;

    }

    /**
     * 根据 xid 更新 所有分支事务的执行状态
     * @param xid xid
     * @param status status
     */
    private void updateTransactionStatus(String xid, int status) {
        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setXid(xid);
        transactionInfo.setStatus(status);
        try {
            transactionInfoMapper.updateOne(transactionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
