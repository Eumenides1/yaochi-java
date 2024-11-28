package com.rookie.stack.yaochi.resp.constants;

import java.nio.charset.StandardCharsets;

/**
 * @author eumenides
 * @description
 * @date 2024/11/28
 */
// RESP 协议的常量定义
public class RespConstants {
    public static final String CRLF = "\r\n"; // 行分隔符
    public static final byte[] CRLF_BYTES = CRLF.getBytes(StandardCharsets.UTF_8); // 字节形式的行分隔符

    public static final String NULL_BULK = "$-1" + CRLF; // 空字符串的 RESP 格式
    public static final byte[] NULL_BULK_BYTES = NULL_BULK.getBytes(StandardCharsets.UTF_8);

    public static final String EMPTY_MULTI_BULK = "*0" + CRLF; // 空多条的 RESP 格式
    public static final byte[] EMPTY_MULTI_BULK_BYTES = EMPTY_MULTI_BULK.getBytes(StandardCharsets.UTF_8);
}
