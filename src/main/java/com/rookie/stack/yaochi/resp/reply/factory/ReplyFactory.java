package com.rookie.stack.yaochi.resp.reply.factory;

import com.rookie.stack.yaochi.resp.reply.custom.BulkReply;
import com.rookie.stack.yaochi.resp.reply.custom.IntReply;
import com.rookie.stack.yaochi.resp.reply.custom.MultiBulkReply;
import com.rookie.stack.yaochi.resp.reply.custom.StatusReply;

import java.util.List;

/**
 * @author eumenides
 * @description 提供动态生成 Reply 对象的便捷方法
 * @date 2024/11/28
 */
public class ReplyFactory {
    public static BulkReply createBulkReply(byte[] data) {
        return new BulkReply(data);
    }

    public static MultiBulkReply createMultiBulkReply(List<byte[]> data) {
        return new MultiBulkReply(data);
    }

    public static IntReply createIntReply(long value) {
        return new IntReply(value);
    }

    public static StatusReply createStatusReply(String status) {
        return new StatusReply(status);
    }
}
