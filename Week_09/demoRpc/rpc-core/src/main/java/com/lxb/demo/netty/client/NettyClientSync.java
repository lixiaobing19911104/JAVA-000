package com.lxb.demo.netty.client;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lxb.demo.api.RpcRequest;
import com.lxb.demo.api.RpcResponse;
import com.lxb.demo.netty.common.RpcProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author lixiaobing
 * @date 2020-12-27 21:31
 * @Description:
 */
@Slf4j
public class NettyClientSync {
    private enum EnumSingleton {
        /**
         * 懒汉枚举单例
         */
        INSTANCE;
        private NettyClientSync instance;

        EnumSingleton() {
            instance = new NettyClientSync();
        }

        public NettyClientSync getSingleton() {
            return instance;
        }

    }

    public static NettyClientSync getInstance() {
        return EnumSingleton.INSTANCE.getSingleton();
    }

    private ConcurrentHashMap<String, Channel> channelPool = new ConcurrentHashMap<>();
    private EventLoopGroup                     clientGroup = new NioEventLoopGroup(new ThreadFactoryBuilder().setNameFormat("client work-%d").build());

    private NettyClientSync() {
    }

    public RpcResponse getResponse(RpcRequest rpcRequest, String url) throws InterruptedException, URISyntaxException {
        RpcProtocol rpcProtocol = toRpcProtocol(rpcRequest);
        URI         uri         = new URI(url);
        String      cacheKey    = uri.getHost() + ":" + uri.getPort();
        if (channelPool.contains(cacheKey)) {
            Channel channel = channelPool.get(cacheKey);
            if (!channel.isActive() || !channel.isWritable() || !channel.isOpen()) {
                log.debug("Channel can't reuse");
            } else {
                try {
                    RpcClientSyncHandler handler = new RpcClientSyncHandler();
                    handler.setLatch(new CountDownLatch(1));
                    channel.pipeline().replace("clientHandler", "clientHandler", handler);
                    channel.writeAndFlush(rpcProtocol).sync();
                    return handler.getResponse();
                } catch (Exception e) {
                    log.debug("channel reuse send msg failed!");
                    channel.close();
                    channelPool.remove(cacheKey);
                }
                log.debug("Handler is busy, please user new channel");
            }
        }

        // 没有或者不可用则新建
        // 并将最终的handler添加到pipeline中，拿到结果后返回
        RpcClientSyncHandler handler = new RpcClientSyncHandler();
        handler.setLatch(new CountDownLatch(1));

        Channel channel = createChannel(uri.getHost(), uri.getPort());
        channel.pipeline().replace("clientHandler", "clientHandler", handler);
        channelPool.put(cacheKey, channel);

        channel.writeAndFlush(rpcProtocol).sync();
        return handler.getResponse();

    }


    private Channel createChannel(String address, int port) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(clientGroup)
                .option(ChannelOption.SO_REUSEADDR, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.AUTO_CLOSE, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .channel(NioSocketChannel.class)
                .handler(new RpcClentInitializer());
        return bootstrap.connect(address, port).sync().channel();
    }

    private RpcProtocol toRpcProtocol(RpcRequest rpcRequest) {
        String      requestJson = JSON.toJSONString(rpcRequest);
        RpcProtocol rpcProtocol = new RpcProtocol();
        rpcProtocol.setContent(requestJson.getBytes(CharsetUtil.UTF_8));
        return rpcProtocol;
    }


}
