package com.zxc.dao.Bill;

import com.zxc.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BillMapper {

    //根据供应商Id查询订单数量
    public int getBillCountByProviderId(@Param("providerId") Integer providerId);

    //增加订单
    public int add(Bill bill);


    //通过查询条件获取供应商列表-getBillList
    public List<Bill> getBillList(@Param("productName") String productName,
                                  @Param("providerId") String providerId,
                                  @Param("isPayment") String isPayment,
                                  @Param("startIndex") Integer startIndex,
                                  @Param("pageSize") Integer pageSize)throws Exception;

    //通过条件查询，查询供货商数量,模糊查询
    /*@Param("productName") String productName,
      @Param("providerId") String providerId,
      @Param("isPayment") String isPayment*/
    public int getBillCount(Map map)throws Exception;//通过map实现

    //通过delId删除Bill
    public int deleteBillById(@Param("id") Integer id)throws Exception;

    //通过billId获取Bill
    public Bill getBillById(@Param("id") Integer id)throws Exception;

    //修改订单信息
    public int modify(Map map)throws Exception;

    //根据供应商Id删除订单信息
    public int deleteBillByProviderId(@Param("providerId") Integer providerId)throws Exception;

}
