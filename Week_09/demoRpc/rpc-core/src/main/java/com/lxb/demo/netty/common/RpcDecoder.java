package com.lxb.demo.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:56
 * @Description:
 */
@Slf4j
public class RpcDecoder extends ByteToMessageDecoder {
    private int length = 0;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("Netty decode run");
        if (in.readableBytes() >= 4) {
            if (length == 0) {
                length = in.readInt();
            }
            if (in.readableBytes() < length) {
                log.info("Readable data is less, wait");
                return;
            }
            if (in.readableBytes() >= length) {
                byte[] content = new byte[length];
                in.readBytes(content);
                RpcProtocol rpcProtocol = new RpcProtocol();
                rpcProtocol.setLen(length);
                rpcProtocol.setContent(content);
                out.add(rpcProtocol);
                length = 0;
            }
        }
    }
}
