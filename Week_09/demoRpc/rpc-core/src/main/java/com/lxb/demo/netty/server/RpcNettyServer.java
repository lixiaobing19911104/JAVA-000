package com.lxb.demo.netty.server;

import com.lxb.demo.netty.common.RpcDecoder;
import com.lxb.demo.netty.common.RpcEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;

/**
 * @author lixiaobing
 * @date 2020-12-27 23:31
 * @Description:
 */
@Slf4j
public class RpcNettyServer {

    private EventLoopGroup boss;
    private EventLoopGroup worker;
    private int            port;

    public RpcNettyServer(int port) {
        this.port = port;
    }

    @PreDestroy
    public void destroy() {
        worker.shutdownGracefully();
        boss.shutdownGracefully();
    }

    public void run() throws InterruptedException {
        boss   = new NioEventLoopGroup(1);
        worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("Message Encoder", new RpcEncoder());
                        pipeline.addLast("Message Decoder", new RpcDecoder());
                        pipeline.addLast("Message Handler", new RpcServerHandler());
                    }
                });
        Channel channel = serverBootstrap.bind(port).sync().channel();
        log.info("Netty server listen in port: " + port);
        channel.closeFuture().sync();


    }


}
