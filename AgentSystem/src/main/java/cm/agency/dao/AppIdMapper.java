package cm.agency.dao;

import cm.agency.entity.as_systemconfigEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppIdMapper {

    public List<as_systemconfigEntity> sletcy();


    public boolean appInsert(@Param("configValue") String configValue, @Param("id") Integer id);

}