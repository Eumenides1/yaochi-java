package com.rookie.stack.yaochi;

import com.rookie.stack.yaochi.config.ConfigLoader;
import com.rookie.stack.yaochi.config.ServerProperties;
import com.rookie.stack.yaochi.resp.reply.Reply;
import com.rookie.stack.yaochi.resp.reply.factory.ReplyFactory;
import com.rookie.stack.yaochi.server.TcpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * @author eumenides
 * @description 入口启动类
 * @date 2024/11/25
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // 动态创建 BulkReply
        Reply bulk = ReplyFactory.createBulkReply("hello".getBytes());
        System.out.println(new String(bulk.toBytes())); // $5\r\nhello\r\n

        // 动态创建 MultiBulkReply
        List<byte[]> arg = Arrays.asList("foo".getBytes(), "bar".getBytes());
        Reply multiBulk = ReplyFactory.createMultiBulkReply(arg);
        System.out.println(new String(multiBulk.toBytes())); // *2\r\n$3\r\nfoo\r\n$3\r\nbar\r\n

        // 动态创建 IntReply
        Reply intReply = ReplyFactory.createIntReply(123);
        System.out.println(new String(intReply.toBytes())); // :123\r\n
//        ServerProperties properties = ConfigLoader.loadConfig("yaochi.properties");
//
//        TcpServer server = new TcpServer(properties);
//
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            logger.info("Received shutdown signal.");
//            server.shutdown();
//        }));
//
//        try {
//            server.start();
//        } catch (InterruptedException e) {
//            logger.error("Server interrupted", e);
//        }
    }
}
