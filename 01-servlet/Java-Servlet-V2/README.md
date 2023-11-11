# JavaEE：Servlet 学习

## 环境说明

- 开发工具：IDEA 2019.3 及以上。
- 构建工具：Gradle。
- 服务器：Tomcat。

**控制台乱码问题**：

- 如果是 Tomcat 服务器内部日志乱码，则在 Tomcat 下的 `conf/logging.properties` 这个文件中添加 `java.util.logging.ConsoleHandler.encoding = GBK/UTF-8` 属性。到底是设置为 GBK 还是 UTF-8 得根据 IDEA 控制台的编码，原则是与 IDEA 控制台的编码保持一致。具体参考 [Java file.encoding](https://www.cnblogs.com/virgosnail/p/10868402.html)。
- 如果不是 Tomcat 服务器内部日志乱码，而是代码打印的日志乱码，则设置 JVM 运行时字符编码，`-Dfile.encoding=UTF-8` 参数。`Dfile.encoding` 用于设置外部环境的编码，Java 的 I/O 操作也是使用此编码。

## 项目说明

1. Servlet-Base：学习基本的 Servlet 知识。
2. Servlet-Filter：学习 Filter。
3. Servlet-SessionManagement：Session 管理。
4. Servlet-FileUploading：实现文件上传。 
5. Servlet-JSP-Base：jstl 相关技术。 
6. Servlet-MVC-Sample-Customer：基础部分综合实战。 
7. Servlet-MVC-Sample-Register：基础部分综合实战。 
8. Servlet-AJAX-Base：Ajax 演示。 
