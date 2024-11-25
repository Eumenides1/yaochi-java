package com.rookie.stack.yaochi.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author eumenides
 * @description 简单返回测试处理器
 * @date 2024/11/25
 */
public class EchoHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger logger = LogManager.getLogger(EchoHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        logger.info("Received message: {}", msg);
        ctx.writeAndFlush(msg + "\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("Exception caught in handler", cause);
        ctx.close();
    }
}
