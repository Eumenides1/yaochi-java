package com.rookie.stack.yaochi.resp.reply.constants;

import com.rookie.stack.yaochi.resp.reply.Reply;
import com.rookie.stack.yaochi.resp.reply.custom.BulkReply;
import com.rookie.stack.yaochi.resp.reply.custom.MultiBulkReply;
import com.rookie.stack.yaochi.resp.reply.custom.StatusReply;

/**
 * @author eumenides
 * @description
 * @date 2024/11/28
 */
// ReplyConstants 管理所有静态常量类型的 RESP 返回
public class ReplyConstants {
    public static final Reply PONG = new StatusReply("PONG");
    public static final Reply OK = new StatusReply("OK");
    public static final Reply NULL_BULK = new BulkReply(null);
    public static final Reply EMPTY_MULTI_BULK = new MultiBulkReply(null);
}