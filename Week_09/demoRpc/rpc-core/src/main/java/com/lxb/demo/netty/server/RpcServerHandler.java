package com.lxb.demo.netty.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lxb.demo.api.RpcRequest;
import com.lxb.demo.api.RpcResponse;
import com.lxb.demo.netty.common.RpcProtocol;
import com.lxb.demo.proxy.ProviderServiceManagement;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lixiaobing
 * @date 2020-12-27 23:05
 * @Description:
 */
@Slf4j
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcProtocol> {


    public RpcServerHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol msg) throws Exception {
        log.info("Netty server receive message:");
        log.info("Message length: " + msg.getLen());
        String content = new String(msg.getContent(), CharsetUtil.UTF_8);
        log.info("Message content: " + content);
        // 获取 RpcProtocol中的 RpcRequest内容，反序列化成 RpcRequest 对象
        RpcRequest rpcRequest = JSON.parseObject(new String(msg.getContent(), CharsetUtil.UTF_8),
                RpcRequest.class);
        log.info("Netty server serializer : " + rpcRequest.toString());
        RpcResponse response = invoke(rpcRequest);

        RpcProtocol rpcProtocol = new RpcProtocol();
        rpcProtocol.setContent(JSON.toJSONString(response, SerializerFeature.WriteClassName).getBytes(CharsetUtil.UTF_8));
        ctx.writeAndFlush(rpcProtocol).sync();
        log.info("return response to client end");


    }

    private RpcResponse invoke(RpcRequest request) {
        RpcResponse rpcResponse  = new RpcResponse();
        String      serviceClass = request.getServiceClass();
        Object service = ProviderServiceManagement.getProviderService(request);
        try {
            Method method = resolveMethodFromClass(service.getClass(), request.getMethod());
            Object result = method.invoke(service, request.getArgv());
            rpcResponse.setResult(result);
            rpcResponse.setStatus(true);
            log.info("Server Response serialize to string return");
            return rpcResponse;
        } catch (Exception t) {
            log.error("rpcerror", t);
            rpcResponse.setException(t);
            rpcResponse.setStatus(false);
            return rpcResponse;
        }
    }

    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        return Arrays.stream(klass.getMethods()).filter(m -> methodName.equals(m.getName())).findFirst().get();
    }

}
