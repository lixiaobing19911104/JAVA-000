package com.lxb.demo.proxy;

import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

/**
 * @author lixiaobing
 * @date 2020-12-27 23:01
 * @Description:
 */
public class RpcByteBody extends RpcProxy implements RpcClient {
    @Override
    @SneakyThrows
    protected <T> Object newProxy(Class<T> serviceClass, String url) {
        return new ByteBuddy().subclass(Object.class)
                .implement(serviceClass)
                .intercept(InvocationHandlerAdapter.of(new RpcInvocationHandler(serviceClass, url)))
                .make()
                .load(RpcByteBody.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();
    }
}
