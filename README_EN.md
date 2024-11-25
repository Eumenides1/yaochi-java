
# Yaochi

**Yaochi** (瑶池) is a high-performance, lightweight, and extensible key-value database inspired by Redis. Named after the mythical **Jade Pool** in Chinese mythology, it symbolizes speed, purity, and limitless possibilities. This project aims to blend the simplicity of Redis with a touch of customizability and modern Java performance techniques.

---

## **Features**

- 🚀 **High Performance**: Built with Netty for asynchronous I/O and optimized concurrency.
- 🔧 **Configurable**: Easily customize through the `server.properties` file.
- 🌈 **Modular Design**: Simplified core for fast prototyping and easy extension.
- 📜 **Rich Logging**: Integrated with Log4j 2 for robust, enterprise-grade logging.
- 🛠️ **Robust Architecture**: Designed for scalability and fault tolerance.
- 🌍 **Cross-Platform**: Runs seamlessly on any platform with Java 8+ support.

---

## **Why Yaochi?**

1. **Simplicity with Power**: A streamlined alternative to traditional databases, focusing on core functionality with room for customization.
2. **Mythological Inspiration**: Just as the Jade Pool represents harmony and beauty, Yaochi strives to offer a harmonious balance of speed, functionality, and extensibility.
3. **Modern Java Ecosystem**: Utilizes modern frameworks and best practices for a cleaner, more maintainable codebase.

---

## **Getting Started**

### Prerequisites

- Java 8+ (JDK 11 recommended)
- Maven (for dependency management)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/yaochi.git
   cd yaochi
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Configure the server:
   Modify `src/main/resources/server.properties` to suit your environment:
   ```properties
   bind=0.0.0.0
   port=6379
   appendOnly=true
   appendFilename=appendonly.aof
   maxClients=100
   requirePass=password123
   databases=16
   ```

4. Run the server:
   ```bash
   java -cp target/yaochi.jar com.rookie.stack.yaochi.Main
   ```

---

## **Usage**

### Connecting to the Server

Use `telnet` or similar tools to interact with the server:

```bash
telnet 127.0.0.1 6379
```

Send a message and get an echo response:
```plaintext
Hello, Yaochi!
Hello, Yaochi!
```

### Logs

Logs are stored in `logs/` by default. The logging system is managed by Log4j 2 with support for:
- Console and file-based logs
- Rolling logs (size and date-based)
- Separate error logs

---

## **Roadmap**

- 🔄 **Persistence**: Implement RDB and AOF for durable storage.
- 📡 **Replication**: Add support for master-slave replication.
- 🕸️ **Cluster Mode**: Introduce distributed clustering for horizontal scaling.
- 📈 **Metrics**: Integrate monitoring and analytics tools.
- 🧩 **Plugins**: Enable plugin-based extensions for custom commands.

---

## **Contributing**

We welcome contributions to Yaochi! Here's how you can help:
1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add a new feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

---

## **License**

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## **Acknowledgments**

- Inspired by:
  - [Redis](https://redis.io/) and its incredible simplicity.
  - [Godis](https://github.com/HDT3213/godis)
- Named after the **Jade Pool (瑶池)** in Chinese mythology, representing purity, balance, and perfection.

---

## **Contact**

For questions or feedback, feel free to reach out via:
- **Email**: jaguarliu831143@gmail.com
- **GitHub Issues**: [Submit an issue](https://github.com/your-username/yaochi/issues)

Let Yaochi bring balance and speed to your data journey! 🌊✨
