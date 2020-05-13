package com.yzy.demo.netty.example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 官方demo
 * Handles a server-side channel.
 * @author yangzyh
 * @date 2020/5/12 18:36
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            // (1)
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            // (2)
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
