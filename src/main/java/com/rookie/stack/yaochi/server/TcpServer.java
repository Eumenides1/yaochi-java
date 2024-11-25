package com.rookie.stack.yaochi.server;

import com.rookie.stack.yaochi.config.ServerProperties;
import com.rookie.stack.yaochi.handler.EchoHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author eumenides
 * @description TCP服务核心
 * @date 2024/11/25
 */
public class TcpServer {
    private static final Logger logger = LogManager.getLogger(TcpServer.class);

    private final ServerProperties properties;
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    public TcpServer(ServerProperties properties) {
        this.properties = properties;
    }

    public void start() throws InterruptedException {
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(
                                    new LineBasedFrameDecoder(1024),
                                    new StringDecoder(),
                                    new StringEncoder(),
                                    new EchoHandler());
                        }
                    });

            ChannelFuture future = bootstrap.bind(properties.bind, properties.port).sync();
            logger.info("Server started on {}:{}", properties.bind, properties.port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("Error occurred while starting the server", e);
        } finally {
            shutdown();
        }
    }
    public void shutdown() {
        logger.info("Shutting down server...");
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        logger.info("Server shut down gracefully.");
    }
}
