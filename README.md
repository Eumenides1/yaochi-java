
# 瑶池 (Yaochi)

**瑶池** 是一个高性能、轻量级、可扩展的键值数据库，灵感来源于 Redis。项目名称取自中国神话中的 **瑶池**，象征着速度、纯净和无限可能。本项目旨在结合 Redis 的简洁性与现代 Java 性能技术，打造一个可定制化的现代数据库解决方案。

---

## **功能特色**

- 🚀 **高性能**：基于 Netty 的异步 I/O，优化并发性能。
- 🔧 **高度可配置**：通过 `server.properties` 文件轻松自定义配置。
- 🌈 **模块化设计**：简化核心逻辑，便于快速原型开发和功能扩展。
- 📜 **丰富的日志功能**：集成 Log4j 2，提供企业级日志管理能力。
- 🛠️ **稳健架构**：设计为可扩展且具有容错能力。
- 🌍 **跨平台支持**：兼容 Java 8+ 环境，运行无障碍。

---

## **快速开始**

### 环境要求

- Java 8+ (推荐使用 JDK 11)
- Maven (用于依赖管理)

### 安装步骤

1. 克隆代码仓库：
   ```bash
   git clone https://github.com/Eumenides1/yaochi-java.git
   cd yaochi
   ```

2. 构建项目：
   ```bash
   mvn clean install
   ```

3. 配置服务：
   修改 `src/main/resources/server.properties` 文件以适应您的环境：
   ```properties
   bind=0.0.0.0
   port=6379
   appendOnly=true
   appendFilename=appendonly.aof
   maxClients=100
   requirePass=password123
   databases=16
   ```

4. 启动服务：
   ```bash
   java -cp target/yaochi.jar com.rookie.stack.yaochi.Main
   ```

---

## **使用方法**

### 连接到服务器

使用 `telnet` 或类似工具连接到服务器：
```bash
telnet 127.0.0.1 6379
```

发送一条消息并接收回显：
```plaintext
Hello, Yaochi!
Hello, Yaochi!
```

### 日志

日志默认存储在 `logs/` 目录下。日志系统由 Log4j 2 管理，支持以下功能：
- 控制台和基于文件的日志记录
- 滚动日志（基于大小和日期）
- 单独的错误日志

---

## **未来规划**

- 🔄 **持久化**：实现 RDB 和 AOF 的持久化存储功能。
- 📡 **复制**：支持主从复制模式。
- 🕸️ **集群模式**：引入分布式集群，支持横向扩展。
- 📈 **性能指标**：集成监控和分析工具。
- 🧩 **插件支持**：启用基于插件的自定义命令扩展。

---

## **贡献指南**

欢迎为 Yaochi 做出贡献！以下是参与的步骤：
1. Fork 本仓库。
2. 创建功能分支：
   ```bash
   git checkout -b feature-name
   ```
3. 提交代码：
   ```bash
   git commit -m "Add a new feature"
   ```
4. 推送到远程分支：
   ```bash
   git push origin feature-name
   ```
5. 提交 Pull Request。

---

## **许可证**

本项目基于 **MIT 许可证**，详情请参阅 [LICENSE](LICENSE) 文件。

---

## **致谢**

- 灵感来源于 ：
  - [Redis](https://redis.io/) 及其极简的设计。
  - [Godis](https://github.com/HDT3213/godis)
- 项目名称取自中国神话中的 **瑶池**，象征速度、和谐与完美。

---

## **联系信息**

如果您有任何问题或反馈，请通过以下方式联系：
- **邮箱**:jaguarliu831143@gmail.com
- **GitHub Issues**: [提交问题](https://github.com/Eumenides1/yaochi-java/issues)

让 Yaochi 为您的数据之旅注入速度与平衡！ 🌊✨

---

**[English Version](README_EN.md)**
