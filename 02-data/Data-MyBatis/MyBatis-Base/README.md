# MyBatis 入门学习

## 1 MyBatis 基础学习

1 MyBatisBasicTest：MyBatis 的最基本用法

- sqlMapConfig_Basic 配置文件
- sqlmap/User.xml 数据库映射文件

2 MyBatisDaoTest：MyBatis dao 模式【DAO 思想的演示】

- 其实就是基于接口编程

3 MyBatisMapperTest：MyBatis 自动 Mapper 映射【推荐使用也是最广泛的使用方式】

- MyBatisConfig02_Mapper.xml
- me.ztiany.mybatis.mapper 下的 Mapper 类和 xml 配置
    - UserMapper
    - OrderMapper

4 SqlMapDetailEmployeeTest/SqlMapDetailDepartmentTest/SqlMapDetailEmployeeAssociationTest：sql映射文件深入-增/删/改/参数处理/关联查询 等

- MyBatisConfig03_SQLMapDetail
- me.ztiany.mybatis.mapper 下的 Mapper 类和 xml 配置
    - EmployeeMapper
    - DepartmentMapper
    - EmployeeMapperAssociation

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
- 运行 task (如果没有生成则手动创建生成路径)即可生成代码
