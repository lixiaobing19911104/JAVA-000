package com.lxb.demo.proxy;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:31
 * @Description:
 */
public interface RpcClient {

    <T> T create(final Class<T> serviceClass, final String url);
}
