package com.zxc.dao;

import com.zxc.pojo.User;
import com.zxc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void testGetUsersList(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.1 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUsersList();

        for(User user : userList){
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void Test1(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);

        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void Test2(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        System.out.println(userList);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void Test3(){
        String s = "leetcodeisis";

        System.out.println(s.charAt(1));
    }

}
