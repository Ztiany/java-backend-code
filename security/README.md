# JaveEE：扩展

## 环境说明

- 开发工具：IDEA 2019.3 及以上。
- 构建工具：Gradle。
- 服务器：Tomcat。

Tomcat 乱码问题：

1. Tomcat6，Tomcat7 默认使用 `IOS8859-1`；Tomcat8 及以后默认使用 `UTF-8`。
2. 因此低版本的需要设置 JVM 运行时字符编码，`-Dfile.encoding=UTF-8`参数。
3. `Dfile.encoding` 用于设置外部环境的编码，Java 的 I/O 操作也是使用此编码。

## 项目说明

1. Shiro-Basic：Shiro 基础
