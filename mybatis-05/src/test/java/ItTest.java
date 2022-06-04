import com.zxc.dao.BlogMapper;
import com.zxc.pojo.Blog;
import com.zxc.utils.IDUtils;
import com.zxc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

public class ItTest {
    @Test
    public void test1(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(IDUtils.getID());
            blog.setTitle("Mybatis");
            blog.setAuthor("狂神说");
            blog.setCreate_time(new Date());
            blog.setViews(9999);

            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setTitle("Java");
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setTitle("Spring");
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setTitle("微服务");
            mapper.addBlog(blog);

            sqlSession.commit();
            sqlSession.close();
    }

    @Test
    public void test2(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

            HashMap<String, String> map = new HashMap<>();
            map.put("title","Java");
            mapper.queryBlogIF(map);

            sqlSession.close();
    }

    @Test
    public void test3(){
        String s = "test.email+alex+aaa";
        String local = s.split("\\+")[2]; // 去掉本地名第一个加号之后的部分
        System.out.println(local);
        System.out.println("push test");
    }
}
