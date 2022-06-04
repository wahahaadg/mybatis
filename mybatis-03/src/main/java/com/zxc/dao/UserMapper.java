package com.zxc.dao;

import com.zxc.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUsersList();

    //根据id查询用户
    User getUserById(int id);

    //分页实现查询
    List<User> getUserByLimit(Map<String,Integer> map);
}
