package com.zxc.dao;

import com.zxc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    @Select("select * from user")
    List<User> getUsersList();

    //根据id查询用户
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    //增加
    @Insert("insert into user(id,name.pwd) values #{id}, #{name}, #{pwd}")
    int addUser(User user);

    //删除

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
    //改

    @Update("update user set name = #{name},pwd = #{pwd} where id = #{id}")
    int updateUser(User user);
    //分页实现查询
    List<User> getUserByLimit(Map<String,Integer> map);
}
