package cm.agency.service;

import cm.agency.entity.as_systemconfigEntity;

import java.util.List;

public interface PreferentiaSeverice {
    /**
     * 优惠所有数据
     * @return
     */
    public List<as_systemconfigEntity> selectPrefern();

    /**
     * 添加优惠数据
     * @param configType
     * @param configTypeName
     * @param configTypeValue
     * @param configValue
     * @param isStart
     * @return
     */
    public  boolean insertPrefern(Integer configType,String configTypeName,Integer configTypeValue,String configValue,Integer isStart);

    /**
     * 修改优惠指定数据
     * @param configTypeName
     * @param configValue
     * @param configTypeValue
     * @param isStart
     * @param id
     * @return
     */
    public  boolean updatPRefen(String configTypeName, String configValue,Integer configTypeValue,Integer isStart,Integer id);

    /**
     * 删除指定数据
     * @param id
     * @return
     */
    public boolean dledtPreern(Integer id);
}
