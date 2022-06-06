import com.zxc.dao.Bill.BillMapper;
import com.zxc.pojo.Bill;
import com.zxc.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillTest {
    @Test
    public void getBillCountByProviderIdTest(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int count = mapper.getBillCountByProviderId(3);
        System.out.println("供应商Id为：3的供应"+count+"种商品");
        sqlSession.close();
    }

    @Test
    public void addTest(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = new Bill();
        bill.setId(19);
        bill.setBillCode("BILL2016_019");
        mapper.add(bill);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBillListTest() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
       /* Bill bill = new Bill();
        bill.setProductName("油");
        bill.setBillCode("1");
        bill.setProviderId(2);*/
        List<Bill> billList = mapper.getBillList("油",
                "1", "1",
                0, 2);
        for (Bill bill : billList) {
            System.out.println(bill);
        }
        sqlSession.close();
    }

    @Test
    public void getBillCountTest() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Map map = new HashMap();
        map.put("productName","油");
        int count = mapper.getBillCount(map);
        System.out.println("数量是" + count);
        sqlSession.close();
    }

    @Test
    public void deleteBillByIdTest() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        mapper.deleteBillById(2);
        sqlSession.close();
    }

    @Test
    public void getBillByIdTest() throws Exception {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill billById = mapper.getBillById(2);

        System.out.println(billById);

        sqlSession.close();
    }

    @Test
    public void modifyTest() throws Exception {
        //修改订单
        //第一步：获得SqlSession对象
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        Date date = new Date();
        params.put("id", "2");
        params.put("billCode", "BILL2021_015");
        params.put("productName", "芦荟汁");
        params.put("productDesc", "干净又卫生");
        params.put("productUnit", "杯");
        params.put("productCount", "10");
        params.put("totalPrice", "9.9");
        params.put("isPayment", "2");
        params.put("modifyBy", "1");
        params.put("modifyDate", date.toLocaleString());
        params.put("providerId", "6");
        int number = billMapper.modify(params);
        System.out.println(number);
        //关闭SqlSession
        sqlSession.close();

    }
}
