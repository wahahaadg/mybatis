package com.zxc.dao.User;

import com.zxc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //得到要登录的用户信息
    User getLoginUser(@Param("userCode") String userCode);
    //根据条件 查询 获取用户列表
    List<User> getUserList(@Param("userName") String userName, @Param("userRole") int userRole,
                           @Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize);
    //修改密码
    int updatePassword(@Param("id") int id,@Param("userPassword") String password);
    //根据用户名 或 角色 查询用户总数
    int getUserCounts(@Param("userName") String userName,@Param("userRole") int userRole);
    //用户管理模块中的  添加用户
    int addUser(User user);
    //用户管理模块中的  添加用户
    int addUserMap(Map<String, Object> params);
    //用户管理模块中的 删除用户
    int deleteUser(@Param("id") int delId);
    //根据用户id 查询用户信息
    User getUserById(@Param("id") int id);
    //用户管理模块中的 修改用户信息
    int modifyUser(User user);
    //用户管理模块中的  修改用户信息
    int modifyUserMap(Map<String, Object> params);
}
