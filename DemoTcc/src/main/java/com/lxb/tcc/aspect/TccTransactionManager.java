package com.lxb.tcc.aspect;

import com.lxb.tcc.entity.TransactionInfo;
import com.lxb.tcc.enums.TransactionMethod;
import com.lxb.tcc.enums.TransactionStatus;
import com.lxb.tcc.mappers.TransactionInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixiaobing
 * @date 2020-12-25 15:02
 * @Description:
 */
@Slf4j
@Service
public class TccTransactionManager {
    private final TransactionInfoMapper transactionInfoMapper;

    public TccTransactionManager(TransactionInfoMapper transactionInfoMapper) {
        this.transactionInfoMapper = transactionInfoMapper;
    }

    public boolean transactionHandle(String xid) {
        // 根据 xid 查询出所有的分支事务信息
        Map<String, Object> condition = new HashMap<>(1);
        condition.put("xid", xid);
        List<Map<String, Object>> branchTransactions = transactionInfoMapper.query(condition);
        // 判断是否所有事务的 try 都执行成功，如果成功则 confirm，反之 cancel
        boolean executeConfirm = true;
        for (Map<String, Object> item : branchTransactions) {
            if (item.get("status").equals(TransactionStatus.TRY_FAILED) || item.get("status").equals(TransactionStatus.CONFIRM_FAILED)) {
                executeConfirm = false;
                break;
            }
        }
        // 执行 confirm 或者 cancel
        if (executeConfirm) {
            return executeMethod(branchTransactions, TransactionMethod.CONFIRM);
        } else {
            return executeMethod(branchTransactions, TransactionMethod.CANCEL);
        }
    }

    /**
     * 通过分支事务注册的 类名和方法名，反射调用相应的 confirm 或者 cancel 方法
     * 这里是串行的，也可以使用线程池进行并行操作
     *
     * @param branchTransactions 分支事务信息
     * @param methodName         confirm 或者 cancel
     * @return bool
     */
    private boolean executeMethod(List<Map<String, Object>> branchTransactions, String methodName) {
        for (Map<String, Object> transaction : branchTransactions) {
            log.info("service info:: " + transaction.toString());
            log.info("service method :: " + transaction.get(methodName).toString());
            try {
                Class<?> clazz = Class.forName(transaction.get("class_name").toString());
                log.info("Service Class::" + clazz.getName());
                Method method = clazz.getDeclaredMethod(transaction.get(methodName).toString());
                log.info("Service Method::" + method.toString());
                Object service = clazz.newInstance();
                Object ret     = method.invoke(service);
                log.info("execute method return: " + ret.toString());
            } catch (Exception e) {
                log.error("err", e);
                return false;
            }
        }
        return true;
    }

    /**
     * 分支事务信息注册
     *
     * @param xid              xid
     * @param className        服务类名
     * @param commitMethodName confirm 方法名
     * @param cancelMethodName cancel 方法名
     */
    public void register(String xid, String className, String commitMethodName, String cancelMethodName) {
        log.info("Register xid::" + xid + " class name:: " + className + " commit method::" + commitMethodName +
                " cancel method::" + cancelMethodName);
        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setXid(xid);
        transactionInfo.setStatus(TransactionStatus.TRY_RUNNING);
        transactionInfo.setClassName(className);
        transactionInfo.setCommitMethodName(commitMethodName);
        transactionInfo.setCancelMethodName(cancelMethodName);
        transactionInfoMapper.insertOne(transactionInfo);
        Map<String, Object> condition = new HashMap<>(1);
        condition.put("xid", xid);
        List<Map<String, Object>> transactionInfos = transactionInfoMapper.query(condition);
        log.info("insert to database:: " + transactionInfos.toString());

    }
}
