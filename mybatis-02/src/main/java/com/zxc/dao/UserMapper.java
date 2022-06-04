package com.zxc.dao;

import com.zxc.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUsersList();

    //根据id查询用户
    User getUserById(int id);


    //增加用户
    void addUser(User user);

    //修改用户
    void updateUser(User user);

    //删除用户
    void deleteUser(int id);
}
