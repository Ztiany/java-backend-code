package me.ztiany.springboot.web.mapper;

import me.ztiany.springboot.web.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    User getUserByIdXml(int id);

    @Select("select * from tbl_user where id=#{id}")
    User getUserById(int id);

}
