package com.lxb.demo.proxy;


import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author lixiaobing
 * @date 2020-12-27 21:58
 * @Description:
 */
@Slf4j
public class RpcClientCglib extends RpcProxy implements RpcClient {
    @Override
    protected <T> Object newProxy(Class<T> serviceClass, String group, String version) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new RpcInvocationHandler(serviceClass, group, version));
        enhancer.setSuperclass(serviceClass);
        log.info("client cglib proxy instance create and return");
        return (T) enhancer.create();

    }

}
