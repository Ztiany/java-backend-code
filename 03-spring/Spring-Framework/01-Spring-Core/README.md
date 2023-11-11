# Spring Framework4 入门

## P1-GetStarted：Spring IOC 入门

bean：Spring IOC 容器中 Bean 的配置。

- ManualJunitTest：Spring 手动加载配置文件，手动从容器中获取对象。
- SpringJUnitTest：使用 Spring 提供的测试框架，简化 Spring 单元测试。
- SpringJUnit5Test：使用 Spring5 提供的测试框架配合 Junit5，简化 Spring 单元测试。
- ProxyTest：演示 Proxy 和 CGLib 代理。

aop ：Spring 切面功能。

- AOPTest：xml 方式配置 aop
- AOPAnnotationTest：注解方式开启 aop
  
jdbc：Spring 的 JDBC 模板 。

- JDBCTest：jdbc 模板的使用

transaction：spring 事务。

- Tx1Test：手动调用 TransactionTemplate 使用事务
- Tx2Test：Spring AOP 事务配置
- Tx3Test：Spring AOP 事务注解式配置

## P2-Beans：Bean 注入详解

- get-started：入门。
- annotation：注解注入。
- auto：自动注入，`byName` 和 `byType`。
- generic：Spring4 泛型注入。

## P3-AOP：AOP 详解

- aop：注解配置 aop。
- aop.xml：xml 方式配置 aop。

## P4-SpringJDBC：Spring 对 JDBC 的支持，以及 Spring 事务

- jdbc：jdbc。
- transaction：事务。
- transaction.xml：事务的 xml 配置方式。

## P5-SpringAnnotation：Spring 纯注解开发

- ioc：ioc 容器注解开发。
- aop：aop 注解开发。
- tx：声明式事务。
