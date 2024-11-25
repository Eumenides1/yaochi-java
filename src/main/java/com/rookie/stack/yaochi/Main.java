package com.rookie.stack.yaochi;

import com.rookie.stack.yaochi.config.ConfigLoader;
import com.rookie.stack.yaochi.config.ServerProperties;
import com.rookie.stack.yaochi.server.TcpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author eumenides
 * @description 入口启动类
 * @date 2024/11/25
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ServerProperties properties = ConfigLoader.loadConfig("yaochi.properties");

        TcpServer server = new TcpServer(properties);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Received shutdown signal.");
            server.shutdown();
        }));

        try {
            server.start();
        } catch (InterruptedException e) {
            logger.error("Server interrupted", e);
        }
    }
}
