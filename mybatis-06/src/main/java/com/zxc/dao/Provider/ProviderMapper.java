package com.zxc.dao.Provider;

import com.zxc.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProviderMapper {
    List<Provider> getProviderList(@Param("proName") String proName, @Param("proCode") String proCode,
                                   @Param("currentPageNo") int currentPageNo,
                                   @Param("pageSize") int pageSize);
    //获取供应商列表
    List<Provider> getProList();
    //增加供应商信息
    int addProvider(Provider provider);
    //增加供应商信息Map
    int addProviderMap(Map<String, Object> params);
    //通过条件查询供应商记录数
    int getProviderCounts(@Param("proName") String proName,@Param("proCode") String proCode);
    //通过供应商Id删除供应商信息
    int deleteProviderById(@Param("id") int delId);
    //根据供应商Id获取供应商信息
    Provider getProviderById(@Param("id") int id);
    //修改供应商
    int modifyProvider(Provider provider);
    //修改供应商
    int modifyProviderMap(Map<String, Object> params);
}
