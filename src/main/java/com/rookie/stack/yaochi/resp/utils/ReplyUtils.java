package com.rookie.stack.yaochi.resp.utils;

import com.rookie.stack.yaochi.resp.reply.Reply;

/**
 * @author eumenides
 * @description
 * @date 2024/11/28
 */
// 工具类，用于判断是否为错误回复
public class ReplyUtils {
    public static boolean isErrorReply(Reply reply) {
        return reply.toBytes()[0] == '-';
    }
}
