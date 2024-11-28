package com.rookie.stack.yaochi.resp.reply;

/**
 * @author eumenides
 * @description
 * @date 2024/11/27
 */
public class CommonReply {
    // 定义常见的 RESP 常量类型回复
    public static final Reply PONG = new Reply.SimpleReply("+PONG\r\n");
    public static final Reply OK = new Reply.SimpleReply("+OK\r\n");
    public static final Reply NULL_BULK = new Reply.SimpleReply("$-1\r\n");
    public static final Reply EMPTY_MULTI_BULK = new Reply.SimpleReply("*0\r\n");
    // 空响应
    public static final Reply NO_REPLY = new Reply.SimpleReply("");

}
