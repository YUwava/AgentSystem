package cm.agency.dao;


import cm.agency.entity.as_systemconfigEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//财务类型接口
public interface As_systemconfigMapper {
        /**
         * 显示账务类型
         * @return List
         */
        public List<as_systemconfigEntity> FinanceShow();

        /**
         * 财务类型的添加
         * @param configType
         * @param configTypeName
         * @param isStart
         * @return
         */
        public  boolean FinanceAdd(@Param("configType") Integer configType,
                                   @Param("configTypeName") String configTypeName,
                                   @Param("isStart") Integer isStart);

        /**
         * 财务类型的修改
         * @return
         */
        public  boolean updater(@Param("configTypeName") String configTypeName,
                                @Param("isStart") Integer isStart, @Param("id") Integer id);

        /**
         *根据 id删除
         * @param id
         * @return
         */
        public  boolean delete(@Param("id") Integer id);

}
