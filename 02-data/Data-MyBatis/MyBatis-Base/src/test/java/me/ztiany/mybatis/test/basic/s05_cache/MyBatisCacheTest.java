package me.ztiany.mybatis.test.basic.s05_cache;

import me.ztiany.mybatis.pojo.cache.CacheUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis 一级缓存与二级缓存。
 */
public class MyBatisCacheTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig04_Cache.xml");
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    //创建SqlSession，这里创建的Session为 org.apache.ibatis.session.defaults.DefaultSqlSession
    private SqlSession newSqlSession() {
        return sqlSessionFactory.openSession();
    }

    @Test
    public void testFirstCache() {
        //执行Sql语句：namespace.sql_id
        SqlSession sqlSession = newSqlSession();
        CacheUser user1 = sqlSession.selectOne("test.findUserById", 10);
        System.out.println(user1);

        CacheUser user2 = sqlSession.selectOne("test.findUserById", 10);
        System.out.println(user2);

        CacheUser user3 = sqlSession.selectOne("test.findUserById", 11);
        System.out.println(user3);

        //关闭session
        sqlSession.close();
    }

    //根据用户名称模糊查询用户列表
    @Test
    public void testSecondCache() {
        //第一次
        SqlSession sqlSession1 = newSqlSession();
        CacheUser user1 = sqlSession1.selectOne("test.findUserById", 10);
        System.out.println(user1);
        sqlSession1.close();

        //第二次
        SqlSession sqlSession2 = newSqlSession();
        CacheUser user2 = sqlSession2.selectOne("test.findUserById", 10);
        System.out.println(user2);

        CacheUser user3 = sqlSession2.selectOne("test.findUserById", 11);
        System.out.println(user3);
        sqlSession2.close();
    }

}
