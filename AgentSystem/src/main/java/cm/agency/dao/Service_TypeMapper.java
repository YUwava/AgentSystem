package cm.agency.dao;

import cm.agency.entity.as_systemconfigEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Service_TypeMapper {
    /**
     * 所有服务类型数据
     * @return
     */
    public List<as_systemconfigEntity> ServiceSelect();

    /**
     * 服务类型添加
     * @param configType
     * @param configTypeName
     * @param isStart
     * @return
     */
    public  boolean ServiceCeAdd(@Param("configType") Integer configType,
                                 @Param("configTypeName") String configTypeName,
                                 @Param("configValue") Integer configValue,
                                 @Param("isStart") Integer isStart);

    /**
     * 修改服务类型数据
     * @param configTypeName
     * @param configValue
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatService(@Param("configTypeName") String configTypeName,
                                 @Param("configValue") Integer configValue,
                                 @Param("isStart") Integer isStart,
                                 @Param("id") Integer id);

}
