package com.lxb.demo.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:54
 * @Description:
 */
@Slf4j
public class RpcEncoder extends MessageToByteEncoder<RpcProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RpcProtocol msg, ByteBuf out) throws Exception {
        log.info("Netty rpc encode run");
        out.writeInt(msg.getContent().length);
        out.writeBytes(msg.getContent());
    }
}
