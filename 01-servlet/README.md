# JavaEE：Servlet 学习

## 环境说明

- 开发工具：IDEA 2019.3 及以上。
- 构建工具：Gradle。
- 服务器：Tomcat。

Tomcat 乱码问题：

1. Tomcat6，Tomcat7 默认使用 `IOS8859-1`；Tomcat8 及以后默认使用 `UTF-8`。
2. 因此低版本的需要设置 JVM 运行时字符编码，`-Dfile.encoding=UTF-8`参数。
3. `Dfile.encoding` 用于设置外部环境的编码，Java 的 I/O 操作也是使用此编码。

## 项目说明

1. Servlet-Base：学习基本的 Servlet 知识。
2. Servlet-Filter：学习 Fliter。
3. Servlet-SessionManagement：Session 管理。
4. Servlet-V3：学习 Servlet3 特性。
5. Servlet-FileUploading：实现文件上传。
6. Servlet-JSP-Base：jstl 相关技术。
7. Servlet-MVC-Sample-Customer：基础部分综合实战。
8. Servlet-MVC-Sample-Register：基础部分综合实战。
9. Servlet-AJAX-Base：ajax 演示。
10. Servlet-Project-BookMall：基础部分综合练习项目。
