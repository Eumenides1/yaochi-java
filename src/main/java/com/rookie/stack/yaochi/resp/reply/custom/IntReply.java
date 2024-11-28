package com.rookie.stack.yaochi.resp.reply.custom;

import com.rookie.stack.yaochi.resp.constants.RespConstants;
import com.rookie.stack.yaochi.resp.reply.Reply;

import java.nio.charset.StandardCharsets;

/**
 * @author eumenides
 * @description 表示整数返回
 * @date 2024/11/28
 */
public class IntReply implements Reply {
    private final long value;

    public IntReply(long value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return (":" + value + RespConstants.CRLF).getBytes(StandardCharsets.UTF_8);
    }
}
