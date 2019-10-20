package cm.agency.dao;

import cm.agency.entity.as_systemconfigEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PreferentialMapper{
    /**
     * 优惠所有数据
     * @return
     */
   public List<as_systemconfigEntity> SelectPreferent();

    /**
     * 添加优惠类型
     * @param configType
     * @param configTypeName
     * @param configTypeValue
     * @param configValue
     * @param isStart
     * @return
     */
   public  boolean addPreferent(@Param("configType") Integer configType,
                                @Param("configTypeName") String configTypeName,
                                @Param("configTypeValue") Integer configTypeValue,
                                @Param("configValue") String configValue,
                                @Param("isStart") Integer isStart
                               );

    /**
     * 修改优惠指定数据
     * @param configTypeName
     * @param configValue
     * @param configTypeValue
     * @param isStart
     * @param id
     * @return
     */
   public  boolean updatPrefrent(@Param("configTypeName") String configTypeName,
                                 @Param("configValue") String configValue,
                                 @Param("configTypeValue") Integer configTypeValue,
                                 @Param("isStart") Integer isStart,
                                 @Param("id") Integer id);

    /**
     * 删除指定数据
     * @param id
     * @return
     */
   public  boolean dletet(@Param("id") Integer id);

}
