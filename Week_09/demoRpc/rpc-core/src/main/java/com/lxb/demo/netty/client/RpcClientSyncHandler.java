package com.lxb.demo.netty.client;

import com.alibaba.fastjson.JSON;
import com.lxb.demo.api.RpcResponse;
import com.lxb.demo.netty.common.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author lixiaobing
 * @date 2020-12-27 21:13
 * @Description:
 */
@Slf4j
public class RpcClientSyncHandler extends SimpleChannelInboundHandler<RpcProtocol> {
    private CountDownLatch countDownLatch;
    private RpcResponse    response;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol msg) throws Exception {
        log.info("Netty client receive message:");
        log.info("Message length: " + msg.getLen());
        String content = new String(msg.getContent(), CharsetUtil.UTF_8);
        log.info("Message content: " + content);
        RpcResponse rpcResponse = JSON.parseObject(content, RpcResponse.class);
        log.info("Netty client serializer : " + rpcResponse.toString());
        response = rpcResponse;
        countDownLatch.countDown();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("error", cause);
        ctx.close();
    }

    /**
     * 锁的初始化
     *
     * @param latch CountDownLatch
     */
    void setLatch(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    /**
     * 阻塞等待结果后返回
     * @return 后台服务器响应
     * @throws InterruptedException exception
     */
    RpcResponse getResponse() throws InterruptedException {
        countDownLatch.await();
        return response;
    }


}
