package me.ztiany.springboot.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * SpringBoot 默认引入了 JdbcTemplate。
 */
@SpringBootTest(classes = {WebDevApplication.class})
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testJdbcTemplate() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tbl_user");
        System.out.println("testJdbcTemplate = " + maps);
        Assertions.assertFalse(maps.isEmpty());
    }

    @Test
    public void testDataSource() {
        System.out.println("testDataSource = " + dataSource.getClass());
        Assertions.assertTrue(dataSource == jdbcTemplate.getDataSource());
    }

}
