package com.zxc.dao;

import com.zxc.pojo.User;
import com.zxc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.1 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUsersList();

        //2.2

        for(User user : userList){
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }


}
