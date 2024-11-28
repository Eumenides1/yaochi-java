package com.rookie.stack.yaochi.reply;

import com.rookie.stack.yaochi.resp.reply.constants.ReplyConstants;
import com.rookie.stack.yaochi.resp.reply.custom.BulkReply;
import com.rookie.stack.yaochi.resp.reply.custom.IntReply;
import com.rookie.stack.yaochi.resp.reply.custom.MultiBulkReply;
import com.rookie.stack.yaochi.resp.reply.custom.StatusReply;
import com.rookie.stack.yaochi.resp.reply.error.StandardErrReply;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author eumenides
 * @description
 * @date 2024/11/28
 */
public class TestRespReplies {

    @Test
    void testBulkReply() {
        // 测试非空 BulkReply
        BulkReply bulk = new BulkReply("hello".getBytes());
        String expected = "$5\r\nhello\r\n";
        assertEquals(expected, new String(bulk.toBytes()));

        // 测试空 BulkReply
        BulkReply emptyBulk = new BulkReply(null);
        String expectedEmpty = "$-1\r\n";
        assertEquals(expectedEmpty, new String(emptyBulk.toBytes()));
    }

    @Test
    void testMultiBulkReply() {
        // 测试非空 MultiBulkReply
        List<byte[]> args = Arrays.asList("foo".getBytes(), "bar".getBytes(), null);
        MultiBulkReply multiBulk = new MultiBulkReply(args);
        String expected = "*3\r\n$3\r\nfoo\r\n$3\r\nbar\r\n$-1\r\n";
        assertEquals(expected, new String(multiBulk.toBytes()));

        // 测试空 MultiBulkReply
        MultiBulkReply emptyMultiBulk = new MultiBulkReply(null);
        String expectedEmpty = "*0\r\n";
        assertEquals(expectedEmpty, new String(emptyMultiBulk.toBytes()));
    }

    @Test
    void testStatusReply() {
        // 测试状态回复
        StatusReply status = new StatusReply("OK");
        String expected = "+OK\r\n";
        assertEquals(expected, new String(status.toBytes()));
    }

    @Test
    void testIntReply() {
        // 测试整数回复
        IntReply intReply = new IntReply(123);
        String expected = ":123\r\n";
        assertEquals(expected, new String(intReply.toBytes()));
    }

    @Test
    void testStandardErrReply() {
        // 测试错误回复
        StandardErrReply err = new StandardErrReply("Custom error");
        String expected = "-Custom error\r\n";
        assertEquals(expected, new String(err.toBytes()));
        assertEquals("Custom error", err.error());
    }

    @Test
    void testReplyConstants() {
        // 测试预定义常量
        assertEquals("+OK\r\n", new String(ReplyConstants.OK.toBytes()));
        assertEquals("+PONG\r\n", new String(ReplyConstants.PONG.toBytes()));
        assertEquals("$-1\r\n", new String(ReplyConstants.NULL_BULK.toBytes()));
    }
}
