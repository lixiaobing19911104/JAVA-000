package com.lxb.demo.proxy;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:34
 * @Description:
 */
public abstract class RpcProxy {

    public <T> T create(Class<T> serviceClass, String group, String version) {
        if (!isExist(serviceClass.getName())) {
            add(serviceClass.getName(), newProxy(serviceClass, group, version));
        }
        return (T) getProxy(serviceClass.getName());
    }

    protected abstract <T> Object newProxy(Class<T> serviceClass, String group, String version);


    private ConcurrentMap<String, Object> proxyCache = new ConcurrentHashMap<>();

    Object getProxy(String className) {
        return proxyCache.get(className);
    }

    Boolean isExist(String className) {
        return proxyCache.containsKey(className);
    }

    void add(String className, Object proxy) {
        proxyCache.put(className, proxy);
    }
}
