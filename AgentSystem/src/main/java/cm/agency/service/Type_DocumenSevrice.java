package cm.agency.service;

import cm.agency.entity.as_systemconfigEntity;

import java.util.List;

public interface Type_DocumenSevrice {

    /**
     * 证件所有数据
     * @return
     */
    public List<as_systemconfigEntity> selectCustomer();

    /**
     * 添加证件
     * @param configType
     * @param configTypeName
     * @param isStart
     * @return
     */
    public  boolean AddsDocument(Integer configType, String configTypeName, Integer isStart);

    /**
     * 修改证件
     * @param configTypeName
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatDocument(String configTypeName, Integer isStart, Integer id);

    /**
     * 删除证件
     * @param id
     * @return
     */
    public  boolean delteDocument(Integer id);


}
