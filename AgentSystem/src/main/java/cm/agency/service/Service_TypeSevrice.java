package cm.agency.service;


import cm.agency.entity.as_systemconfigEntity;

import java.util.List;

public interface Service_TypeSevrice {
    /**
     * 所有服务类型接口
     * @return
     */
    public List<as_systemconfigEntity> ServiceSelect();

    /**
     * 增加服务类型数据
     * @param configType
     * @param configTypeName
     * @param configValue
     * @param isStart
     * @return
     */
    public  boolean ServiceCeAdd_type(Integer configType, String configTypeName,Integer configValue,Integer isStart);

    /**
     * 修改服务类型数据
     * @param configTypeName
     * @param configValue
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatSerice( String configValue, Integer configTypeName,Integer isStart,Integer id);
}
