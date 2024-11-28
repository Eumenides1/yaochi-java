package com.rookie.stack.yaochi.resp.reply.custom;

import com.rookie.stack.yaochi.resp.constants.RespConstants;
import com.rookie.stack.yaochi.resp.reply.Reply;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author eumenides
 * @description 用于存储字符串列表
 * @date 2024/11/28
 */
public class MultiBulkReply implements Reply {
    private final List<byte[]> args;

    public MultiBulkReply(List<byte[]> args) {
        this.args = args;
    }

    @Override
    public byte[] toBytes() {
        // 检查 args 是否为 null
        if (args == null) {
            return "*0\r\n".getBytes(StandardCharsets.UTF_8);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("*").append(args.size()).append(RespConstants.CRLF);
        for (byte[] arg : args) {
            if (arg == null) {
                builder.append(RespConstants.NULL_BULK);
            } else {
                builder.append("$").append(arg.length).append(RespConstants.CRLF);
                builder.append(new String(arg, StandardCharsets.UTF_8)).append(RespConstants.CRLF);
            }
        }
        return builder.toString().getBytes(StandardCharsets.UTF_8);
    }

    public static MultiBulkReply makeMultiBulkReply(List<byte[]> args) {
        return new MultiBulkReply(args);
    }
}
