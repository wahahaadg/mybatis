package com.zxc.dao;

import com.zxc.pojo.User;
import com.zxc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    public void getUserById(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public  void addUser(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(4,"niude","135796"));

        //增删改要提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"buniude","135796"));

        //增删改要提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        //增删改要提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public  void getUserLike(){
        //1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("%niu%");

        for(User user : userList){
            System.out.println(user);
        }

        //增删改要提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void intTest(){
        String s = "wvu";
        String target = "tu";
        int n1 = s.length();
        int n2 = target.length();
        int[] num1 = new int[26];
        int[] num2 = new int[26];

        for(int i = 0; i < n1; i++){
            char c = s.charAt(i);
            int temp = c-'a';
            num1[temp]++;
        }
        System.out.println(Arrays.toString(num1));
        for(int i = 0; i < n2; i++){
            char c = target.charAt(i);
            int temp = c-'a';
            num2[temp]++;
        }
        System.out.println(Arrays.toString(num2));
        int[] result = new int[26];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(num2[i] != 0){
                result[i] = num1[i] / num2[i];
                min = Math.min(min,result[i]);
            }
        }
        System.out.println(min);
    }
}
