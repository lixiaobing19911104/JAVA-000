package com.lxb.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:39
 * @Description:
 */
public class RpcClientJdk extends RpcProxy implements RpcClient {

    @Override
    protected <T> Object newProxy(Class<T> serviceClass, String url) {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{serviceClass},
                new RpcInvocationHandler(serviceClass, url));
    }
}
