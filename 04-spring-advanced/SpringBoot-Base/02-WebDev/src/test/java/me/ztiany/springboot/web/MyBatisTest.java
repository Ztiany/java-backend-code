package me.ztiany.springboot.web;

import me.ztiany.springboot.web.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {WebDevApplication.class})
public class MyBatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapper() {
        System.out.println(userMapper.getUserById(1));
    }

    @Test
    public void testMapperXml() {
        System.out.println(userMapper.getUserByIdXml(1));
    }

}
