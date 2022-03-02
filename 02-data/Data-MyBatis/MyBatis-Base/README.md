# MyBatis 入门学习

## 1 MyBatis 基础学习

步骤 1：MyBatisBasicTest，演示 MyBatis 最基本的用法。

- sqlMapConfig_Basic 配置文件
- sqlmap/User.xml 数据库映射文件

步骤 2：MyBatisDaoTest，演示以  dao 模式来使用 MyBatis 。

- 其实就是基于接口编程

步骤 3：MyBatisMapperTest，演示以 Mapper 映射方式来使用 MyBatis，对比上面的方式，不再需要手动传入 xml 的配置的 sql id，而是实现了与 Mapper 接口自动映射【推荐的使用方式】

- MyBatisConfig02_Mapper.xml
- me.ztiany.mybatis.mapper 下的 Mapper 类和 xml 配置
    - UserMapper
    - OrderMapper

步骤 4：SqlMapDetailEmployeeTest/SqlMapDetailDepartmentTest/SqlMapDetailEmployeeAssociationTest，深入 sql 映射文件，包括增/删/改/参数处理/关联查询等。

- MyBatisConfig03_SQLMapDetail
- me.ztiany.mybatis.mapper 下的 Mapper 类和 xml 配置
    - EmployeeMapper
    - DepartmentMapper
    - EmployeeMapperAssociation

步骤 5：MyBatisCacheTest，演示 MyBatis 的 1、2 级别缓存，以及配置第三方二级缓存 ehcache。

```
第三方二级缓存配置步骤：

1. gradle 中加入第三方 ehcache 依赖。
2. 在 resource 文件夹下添加 ehcache.xml 文件，对 ehcache 进行配置。
3. 在 sql 映射文件的 cache 节点中，指定第三方缓存类型。<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
```

步骤 6：MyBatisPagingTest，演示 MyBatis 分页插件

- 具体参考 <https://github.com/pagehelper/Mybatis-PageHelper>

## 2 Spring 集成 MyBatis

- SpringDaoTest：MyBatis 整合 Spring，dao模式
- SpringMapperTest：MyBatis 整合 Spring，手动配置mapper模式 + MyBatis事务演示
- SpringMapperScannerTest：MyBatis 整合 Spring，自动扫描Mapper
- SpringTxTest：MyBatis 整合 Spring，使用 Spring 事务管理 MyBatis

## 3 MyBatis-Plugin

根据 SQL 生成 POJO、Mapper、和 xml 映射文件，支持单表查询。

- 在 gradle 中添加依赖和配置插件，生成的 task 是`other/mbGenerator`
- 使用 `src/main/resource/generatorConfig.xml`配置插件
- 生成的代码配置在根目录 generate 目录下
- 运行 task （如果没有生成则手动创建生成路径）即可生成代码

具体参考：<https://github.com/kimichen13/mybatis-generator-plugin>
