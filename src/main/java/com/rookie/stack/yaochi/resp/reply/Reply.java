package com.rookie.stack.yaochi.resp.reply;

/**
 * @author eumenides
 * @description Reply 接口，表示 RESP 协议的通用返回类型
 * @date 2024/11/26
 */
public interface Reply {
    byte[] toBytes();

    class SimpleReply implements Reply {
        private final byte[] bytes;

        // 构造函数传入 RESP 格式的字节数组
        SimpleReply(String respText) {
            this.bytes = respText.getBytes();
        }

        @Override
        public byte[] toBytes() {
            return bytes;
        }
    }
}
