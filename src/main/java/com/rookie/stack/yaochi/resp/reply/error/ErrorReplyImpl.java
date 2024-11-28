package com.rookie.stack.yaochi.resp.reply.error;

/**
 * @author eumenides
 * @description 通用错误回复实现
 * @date 2024/11/27
 */
public class ErrorReplyImpl implements ErrorReply{
    private final String errorMessage;
    private final byte[] serializedBytes;

    public ErrorReplyImpl(String errorMessage, String respText) {
        this.errorMessage = errorMessage;
        this.serializedBytes = respText.getBytes();
    }

    @Override
    public byte[] toBytes() {
        return serializedBytes;
    }

    @Override
    public String error() {
        return errorMessage;
    }
}
