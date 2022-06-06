import com.zxc.dao.Provider.ProviderMapper;
import com.zxc.pojo.Provider;
import com.zxc.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class ProviderTest {
    @Test
    public void getProList(){
        //查询所有供应商信息
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providerList = new ArrayList<Provider>();
        providerList= providerMapper.getProList();
        for (Provider provider : providerList) {
            System.out.println(provider);
        }
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getProviderList(){
        //根据条件查询供应商信息
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providerList = new ArrayList<Provider>();
        providerList= providerMapper.getProviderList("兴化佳美调味品厂","JS_GYS001",1,2);
        for (Provider provider : providerList) {
            System.out.println(provider);
        }
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void addProviderMap(){
        //新增供应商
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        Date date = new Date();
        params.put("id", "16");
        params.put("proCode", "GZ_GYS156");
        params.put("proName", "广州市白云胡华五金制品厂");
        params.put("proDesc", "长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等");
        params.put("proContact", "孙欣弈");
        params.put("proPhone", "17779674555");
        params.put("proAddress", "中国北京市大兴区旧宫");
        params.put("proFax", "010-35576785");
        params.put("createdBy", "1");
        params.put("creationDate", date.toLocaleString());
        int number = providerMapper.addProviderMap(params);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getProviderCounts(){
        //查询供应商信息的数量
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        int number = providerMapper.getProviderCounts("深圳市喜来客商贸有限公司","GZ_GYS002");
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void deleteProviderById(){
        //删除供应商信息
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        int number = providerMapper.deleteProviderById(16);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getProviderById(){
        //根据ID查询供应商信息
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider = providerMapper.getProviderById(2);
        System.out.println(provider.toString());
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void modifyProviderMap(){
        //修改供应商信息
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        Date date = new Date();
        params.put("id", "16");
        params.put("proCode", "GZ_GYS155");
        params.put("proName", "广州市白云胡华五金制品厂");
        params.put("proDesc", "长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等");
        params.put("proContact", "孙欣弈");
        params.put("proPhone", "17779674555");
        params.put("proAddress", "中国北京市大兴区旧宫");
        params.put("proFax", "010-35576785");
        params.put("modifyBy", "1");
        params.put("modifyDate", date.toLocaleString());
        int number = providerMapper.modifyProviderMap(params);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();
    }
}
