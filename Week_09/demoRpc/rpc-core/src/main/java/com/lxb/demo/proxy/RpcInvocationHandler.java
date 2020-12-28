package com.lxb.demo.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.lxb.demo.api.RpcRequest;
import com.lxb.demo.api.RpcResponse;
import com.lxb.demo.discovery.DiscoveryClient;
import com.lxb.demo.netty.client.NettyClientSync;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:43
 * @Description:
 */
@Slf4j
public class RpcInvocationHandler implements InvocationHandler, MethodInterceptor {

    private final Class<?>        serviceClass;
    private final String          group;
    private final String          version;
    private final DiscoveryClient discoveryClient = new DiscoveryClient();

    public RpcInvocationHandler(Class<?> serviceClass) {
        this(serviceClass, "default", "default");
    }

    public RpcInvocationHandler(Class<?> serviceClass, String group, String version) {
        this.serviceClass = serviceClass;
        this.group        = group;
        this.version      = version;
        System.out.println("Client Service Class Reflect: " + group + ":" + version);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return process(serviceClass, method, args);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return process(serviceClass, method, objects);
    }

    private Object process(Class<?> service, Method method, Object[] params) {
        log.info("Client proxy instance method invoke");

        // 自定义了Rpc请求的结构 RpcRequest,放入接口名称、方法名、参数
        log.info("Build Rpc request");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setArgv(params);
        rpcRequest.setMethod(method.getName());
        rpcRequest.setServiceClass(serviceClass.getName());
        rpcRequest.setGroup(group);
        rpcRequest.setVersion(version);
        String url = null;
        try {
            url = discoveryClient.getProviders(service.getName(), group, version);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (url == null) {
            return null;
        }


        log.info("Client send request to Server");
        RpcResponse rpcResponse;
        try {
            rpcResponse = NettyClientSync.getInstance().getResponse(rpcRequest, url);
        } catch (InterruptedException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        if (!rpcResponse.getStatus()) {
            log.info("Client receive exception");
            rpcResponse.getException().printStackTrace();
            return null;
        }
        // 序列化成对象返回
        log.info("Response:: " + rpcResponse.getResult());
        return rpcResponse.getResult();
    }
}
