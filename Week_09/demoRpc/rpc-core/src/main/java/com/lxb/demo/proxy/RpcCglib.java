package com.lxb.demo.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lixiaobing
 * @date 2020-12-27 22:59
 * @Description:
 */
public class RpcCglib extends RpcProxy implements RpcClient {
    @Override
    protected <T> Object newProxy(Class<T> serviceClass, String url) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new RpcInvocationHandler(serviceClass, url));
        enhancer.setSuperclass(serviceClass);
        return enhancer.create();
    }
}
