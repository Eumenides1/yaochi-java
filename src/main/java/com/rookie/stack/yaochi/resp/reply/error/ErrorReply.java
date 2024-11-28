package com.rookie.stack.yaochi.resp.reply.error;

import com.rookie.stack.yaochi.resp.reply.Reply;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author eumenides
 * @description ErrorReply 接口，继承自 Reply，扩展了获取错误消息的方法
 * @date 2024/11/27
 */
public interface ErrorReply extends Reply {
    String error();
    // 工厂类，用于管理和生成常见的错误回复
    class Factory {
        private static final Map<String, ErrorReply> PREDEFINED_ERRORS;

        static {
            Map<String, ErrorReply> errors = new HashMap<>();
            errors.put("unknown", new ErrorReplyImpl("Err unknown", "-Err unknown\r\n"));
            errors.put("syntax", new ErrorReplyImpl("Err syntax error", "-Err syntax error\r\n"));
            errors.put("wrongType", new ErrorReplyImpl(
                    "WRONGTYPE Operation against a key holding the wrong kind of value",
                    "-WRONGTYPE Operation against a key holding the wrong kind of value\r\n"
            ));
            PREDEFINED_ERRORS = Collections.unmodifiableMap(errors);
        }

        public static ErrorReply getPredefined(String key) {
            return PREDEFINED_ERRORS.get(key);
        }

        public static ErrorReply createArgNumError(String cmd) {
            String message = "ERR wrong number of arguments for '" + cmd + "' command";
            String resp = "-ERR wrong number of arguments for '" + cmd + "' command\r\n";
            return new ErrorReplyImpl(message, resp);
        }

        public static ErrorReply createProtocolError(String msg) {
            String message = "ERR Protocol error: '" + msg + "'";
            String resp = "-ERR Protocol error: '" + msg + "'\r\n";
            return new ErrorReplyImpl(message, resp);
        }
    }
}
