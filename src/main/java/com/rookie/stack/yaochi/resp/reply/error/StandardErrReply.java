package com.rookie.stack.yaochi.resp.reply.error;

import java.nio.charset.StandardCharsets;

/**
 * @author eumenides
 * @description 表示标准的错误回复
 * @date 2024/11/28
 */
public class StandardErrReply implements ErrorReply {
    private final String status;

    public StandardErrReply(String status) {
        this.status = status;
    }

    @Override
    public byte[] toBytes() {
        return ("-" + status + "\r\n").getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String error() {
        return status;
    }

    public static StandardErrReply makeErrReply(String status) {
        return new StandardErrReply(status);
    }
}
