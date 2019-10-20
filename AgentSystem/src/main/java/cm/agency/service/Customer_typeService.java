package cm.agency.service;

import cm.agency.entity.as_systemconfigEntity;

import java.util.List;

public interface Customer_typeService {
    /**
     * 客户所有数据
     * @return
     */
    public List<as_systemconfigEntity> selectCustomer();

    /**
     * 添加客户信息
     * @param configType
     * @param configTypeName
     * @param isStart
     * @return
     */
    public  boolean AddsCustome_typeService(Integer configType, String configTypeName, Integer isStart);

    /**
     * 修改客户信息
     * @param configTypeName
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatCustome_typeService(String configTypeName, Integer isStart, Integer id);

    /**
     * 根据id删除指定数据
     * @param id
     * @return
     */
    public  boolean delteCustome_type(Integer id);

}
