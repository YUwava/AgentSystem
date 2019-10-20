package cm.agency.dao;

import cm.agency.entity.as_systemconfigEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Type_DocumentMapper {

    /**
     * 证件所有数据类型
     * @return
     */
    public List<as_systemconfigEntity>  selectDocumentMapper();

    /**
     * 添加证件
     * @param configType
     * @param configTypeName
     * @param isStart
     * @return
     */
    public  boolean AddDocument(@Param("configType") Integer configType,
                               @Param("configTypeName") String configTypeName,
                               @Param("isStart") Integer isStart);

    /**修改客户信息
     * @param configTypeName
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatDocument(@Param("configTypeName") String configTypeName,
                                  @Param("isStart") Integer isStart, @Param("id") Integer id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public  boolean deleteDocument(@Param("id") Integer id);
}
