package com.rookie.stack.yaochi.resp.reply.custom;

import com.rookie.stack.yaochi.resp.reply.Reply;

import java.nio.charset.StandardCharsets;

/**
 * @author eumenides
 * @description  表示状态字符串的动态返回
 * @date 2024/11/28
 */
public class StatusReply implements Reply {
    private final String status;

    public StatusReply(String status) {
        this.status = status;
    }

    @Override
    public byte[] toBytes() {
        return ("+" + status + "\r\n").getBytes(StandardCharsets.UTF_8);
    }
}
