package com.rookie.stack.yaochi.config;

/**
 * @author eumenides
 * @description yaochi 默认配置类
 * @date 2024/11/25
 */
public class ServerProperties {
    // 默认绑定地址
    public String bind = "127.0.0.1";
    // 默认端口号
    public int port = 6379;
    public boolean appendOnly = false;
    public String appendFilename = "appendonly.aof";
    public int maxClients = 100;
    public String requirePass = "";
    public int databases = 16;
}
