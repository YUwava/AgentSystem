package cm.agency.dao;

import org.apache.ibatis.annotations.Param;

public interface Years_typeMapper {

    public  boolean YserInsert(@Param("configType")Integer configType,
                               @Param("configTypeName") String configTypeName,
                               @Param("configValue")String configValue,
                               @Param("isStart")Integer isStart);

}
