package com.rookie.stack.yaochi.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @author eumenides
 * @description 配置类加载器
 * @date 2024/11/25
 */
public class ConfigLoader {
    private static final Logger logger = LogManager.getLogger(ConfigLoader.class);
    public static ServerProperties loadConfig(String filename) {
        Configurations configs = new Configurations();
        ServerProperties properties = new ServerProperties();
        try {
            Configuration config = configs.properties(new File(filename));
            properties.bind = config.getString("bind", properties.bind);
            properties.port = config.getInt("port", properties.port);
            properties.appendOnly = config.getBoolean("appendOnly", properties.appendOnly);
            properties.appendFilename = config.getString("appendFilename", properties.appendFilename);
            properties.maxClients = config.getInt("maxClients", properties.maxClients);
            properties.requirePass = config.getString("requirePass", properties.requirePass);
            properties.databases = config.getInt("databases", properties.databases);
            logger.info("Configuration loaded successfully from {}", filename);
        } catch (Exception e) {
            logger.error("Failed to load configuration from {}. Using defaults.", filename, e);
        }
        return properties;
    }

}
