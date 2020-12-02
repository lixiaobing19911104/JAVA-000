package com.lxb.rw.aspect;

import com.lxb.rw.context.DataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author lixiaobing
 * @date 2020-12-03 01:21
 * @Description:
 */
@Aspect
@Component
public class DataOperateAop {
    @Before("execution(* com.lxb.rw.mapper..*.get*(..)) || execution(* com.lxb.rw.mapper..*.query*(..))")
    public void setReadDataSourceType ()
    {
        DataSourceContextHolder.read ();
        System.out.println ("dataSource切换到：Read");
    }
    @Before ("execution(* com.lxb.rw.mapper..*.add*(..)) || execution(* com.lxb.rw.mapper..*.update*(..))"
            + "|| execution(* com.lxb.rw.mapper..*.del*(..))")
    public void setWriteDataSourceType ()
    {
        DataSourceContextHolder.write ();
        System.out.println ("dataSource切换到：write");
    }

}
