package com.zxc.dao;

import com.zxc.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据sql
    void addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogForEach(Map map);
}
