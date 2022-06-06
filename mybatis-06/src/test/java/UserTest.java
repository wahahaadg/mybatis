import com.zxc.dao.User.UserMapper;
import com.zxc.pojo.User;
import com.zxc.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class UserTest {
    @Test
    public void getLoginTest(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User loginUser = mapper.getLoginUser("admin");
        System.out.println(loginUser);
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //根据ID查询用户
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(8);
        System.out.println(user);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getUserCounts(){
        //根据用户编码查询用户数量
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int number = userMapper.getUserCounts("测试",1);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void updatePassword(){
        //根据ID修改用户密码
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int number = userMapper.updatePassword(8,"123456");
        System.out.println(number);
        //提交：因为我在 sqlSessionFactory.openSession(true);//默认提交事务，所有这里不用再提交了
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getUserList(){
        //获取用户
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        List<User> userList = new ArrayList<User>();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userList= userMapper.getUserList("管理员",1,1,5);
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void addUser(){
        //新增用户
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user =new User(28, "hhh", "哈哈哈", "123456",
//                1, new Date(), "17779674555", "中国",
//                2, 1, new Date());
//        int number = userMapper.addUser(user);
        //另外一种：
        Map<String, Object> params = new HashMap<String, Object>();
        Date date = new Date();
        params.put("id", "26");
        params.put("userCode", "hhh");
        params.put("userName", "哈哈哈");
        params.put("userPassword", "123456");
        params.put("gender", "1");
        params.put("birthday", "2016-09-30");
        params.put("phone", "17779674555");
        params.put("address", "中国");
        params.put("userRole", "2");
        params.put("createdBy", "1");
        params.put("creationDate", date.toLocaleString());
        int number = userMapper.addUserMap(params);
//        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void modifyUserMap(){
        //修改用户modifyUserMap
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        Date date = new Date();
        params.put("id", "26");
        params.put("userCode", "hhh");
        params.put("userName", "哈");
        params.put("userPassword", "111111");
        params.put("gender", "1");
        params.put("birthday", "2016-09-30");
        params.put("phone", "13689674534");
        params.put("address", "中国");
        params.put("userRole", "2");
        params.put("modifyBy", "1");
        params.put("modifyDate", date.toLocaleString());
        int number = userMapper.modifyUserMap(params);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void deleteUser() {
        //删除用户
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int number = userMapper.deleteUser(4);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
}
