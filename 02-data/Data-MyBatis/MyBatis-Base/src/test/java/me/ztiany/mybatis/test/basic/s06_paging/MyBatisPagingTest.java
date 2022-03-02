package me.ztiany.mybatis.test.basic.s06_paging;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.ztiany.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * MyBatis 分页插件
 *
 * @author Ztiany
 * Email ztiany3@gmail.com
 * Date 18.5.26 22:16
 */
public class MyBatisPagingTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig05_Paging.xml");
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    //创建SqlSession，这里创建的Session为 org.apache.ibatis.session.defaults.DefaultSqlSession
    private SqlSession newSqlSession() {
        return sqlSessionFactory.openSession();
    }

    /*
        limit index,pageSize
        index:当前页的起始索引

        pageSize：每页显示的条数
        pageNum：当前页的页码

        index=(pageNum-1)*pageSize

        使用MyBatis的分页插件实现分页功能：
            1、需要在查询功能之前开启分页
                PageHelper.startPage(int pageNum, int pageSize);
            2、在查询功能之后获取分页相关信息
                PageInfo<Emp> page = new PageInfo<>(list, 5);
                    list表示分页数据
                    5表示当前导航分页的数量
     */
    @Test
    public void testPaging() {
        //执行Sql语句：namespace.sql_id
        SqlSession sqlSession = newSqlSession();
        PageHelper.startPage(1, 4);
        List<User> users = sqlSession.selectList("test.findAllUsers");
        PageInfo<User> page = new PageInfo<>(users, 2);
        System.out.println("page: " + page);
        System.out.println("users: " + users);
        //关闭session
        sqlSession.close();
    }

}