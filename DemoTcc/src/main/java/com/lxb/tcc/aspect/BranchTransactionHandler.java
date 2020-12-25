package com.lxb.tcc.aspect;

import com.lxb.tcc.annotation.TccAction;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lixiaobing
 * @date 2020-12-25 15:18
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class BranchTransactionHandler {
    private TccTransactionManager tccTransactionManager;

    public BranchTransactionHandler(TccTransactionManager tccTransactionManager) {
        this.tccTransactionManager = tccTransactionManager;
    }

    @Pointcut(value = "@annotation(com.lxb.tcc.annotation.TccAction)")
    public void branchTransaction() {
    }

    @Before("branchTransaction()")
    public void branchTransactionHandler(JoinPoint point) {
        // 获取分支事务服务类名，用于后面反射类加载
        Class<?>        target    = point.getTarget().getClass();
        String          className = target.getName();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method          method    = signature.getMethod();
        TccAction       annotation = method.getAnnotation(TccAction.class);
        String          commitMethodName = annotation.confirmMethod();
        String          cancelMethodName = annotation.cancelMethod();
        tccTransactionManager.register(RootContext.get(), className, commitMethodName, cancelMethodName);

    }
}
