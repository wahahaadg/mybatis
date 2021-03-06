import com.zxc.dao.BlogMapper;
import com.zxc.pojo.Blog;
import com.zxc.utils.IDUtils;
import com.zxc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

        HashMap<String, Integer> map = new HashMap<>();
        //map.put("title","Java");
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog: blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test3(){
        int min = 2;
    }
}
