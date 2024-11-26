package com.rookie.stack.yaochi.resp;

/**
 * @author eumenides
 * @description Reply 接口，表示 RESP 协议的通用返回类型
 * @date 2024/11/26
 */
public interface Reply {
    byte[] toBytes();
    // 工具类，用于管理常量类型回复
    class Constants {
        // 定义常见的 RESP 常量类型回复
        public static final Reply PONG = new SimpleReply("+PONG\r\n");
        public static final Reply OK = new SimpleReply("+OK\r\n");
        public static final Reply NULL_BULK = new SimpleReply("$-1\r\n");
        public static final Reply EMPTY_MULTI_BULK = new SimpleReply("*0\r\n");
        public static final Reply NO_REPLY = new SimpleReply(""); // 空响应
    }
    // 通用的简单常量回复类
    class SimpleReply implements Reply {
        private final byte[] bytes;

        // 构造函数传入 RESP 格式的字节数组
        private SimpleReply(String respText) {
            this.bytes = respText.getBytes();
        }

        @Override
        public byte[] toBytes() {
            return bytes;
        }
    }
}
