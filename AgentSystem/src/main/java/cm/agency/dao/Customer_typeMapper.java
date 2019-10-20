package cm.agency.dao;

import cm.agency.entity.as_systemconfigEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Customer_typeMapper {
    /**
     * 客户所有数据
     * @return
     */
    public List<as_systemconfigEntity> SelectCustomer();

    /**
     * 添加客户数据
     * @param configType
     * @param configTypeName
     * @param isStart
     * @return
     */
    public  boolean insertCustomer(@Param("configType") Integer configType,
                                   @Param("configTypeName") String configTypeName,
                                   @Param("isStart") Integer isStart);

    /**
     * 修改客户信息
     * @param configTypeName
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatCuserome(@Param("configTypeName") String configTypeName,
                                  @Param("isStart") Integer isStart, @Param("id") Integer id);

    /**
     * 根据id删除指定数据
     * @param id
     * @return
     */
    public  boolean deleteCuserome(@Param("id") Integer id);

}
