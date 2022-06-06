import com.zxc.dao.Role.RoleMapper;
import com.zxc.pojo.Role;
import com.zxc.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleTest {
    @Test
    public void getRoleListTest() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.getRoleList();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void add() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Map map = new HashMap();
        map.put("id",5);
        map.put("roleCode","zzzz");
        map.put("roleName","BB");
        mapper.add(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.deleteRoleById(5);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void modify() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Map map = new HashMap();
        map.put("roleCode","smallsmall");
        map.put("roleName","bigbig");
        map.put("createdBy",666);
        map.put("modifyBy",7777);
        map.put("id",4);


        mapper.modify(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserById() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role roleById = mapper.getRoleById(2);
        System.out.println(roleById);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void roleCodeIsExist()throws Exception{
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        int count = mapper.roleCodeIsExist("SMBMS_ADMIN");
        System.out.println(count);
        sqlSession.close();
    }
}
