package com.rookie.stack.yaochi.resp.reply.custom;

import com.rookie.stack.yaochi.resp.constants.RespConstants;
import com.rookie.stack.yaochi.resp.reply.Reply;

import java.nio.charset.StandardCharsets;

/**
 * @author eumenides
 * @description 表示二进制安全字符串的动态返回
 * @date 2024/11/28
 */
public class BulkReply implements Reply {
    private final byte[] data;

    public BulkReply(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] toBytes() {
        if (data == null || data.length == 0) {
            return ("$-1" + RespConstants.CRLF).getBytes(StandardCharsets.UTF_8);
        }
        return ("$" + data.length + RespConstants.CRLF + new String(data, StandardCharsets.UTF_8) + RespConstants.CRLF)
                .getBytes(StandardCharsets.UTF_8);
    }
}
