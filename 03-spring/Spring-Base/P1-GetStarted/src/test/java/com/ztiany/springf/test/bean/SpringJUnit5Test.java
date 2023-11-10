package com.ztiany.springf.test.bean;

import com.ztiany.springf.test.bean.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

/**
 * 使用 Spring5 + Junit5 提供的测试框架，简化 Spring 单元测试
 */
//指定创建容器时使用哪个配置文件
@SpringJUnitConfig(locations = "classpath:bean_config.xml")
public class SpringJUnit5Test {

    //将名为user的对象注入到mUser变量中
    @Resource(name = "user1")
    private User mUser;

    @Test
    public void fun1() {
        System.out.println(mUser);
        Assertions.assertNotNull(mUser);
    }

}
