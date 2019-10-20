package cm.agency.service.impl;

import cm.agency.dao.PreferentialMapper;
import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.PreferentiaSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Preferentiaimpl implements PreferentiaSeverice {
    @Autowired
    private PreferentialMapper preferentialMapper;

    public void setPreferentialMapper(PreferentialMapper preferentialMapper) {
        this.preferentialMapper = preferentialMapper;
    }

    /**
     * 优惠数据
     * @return
     */
    @Override
    public List<as_systemconfigEntity> selectPrefern() {
        return preferentialMapper.SelectPreferent();
    }

    /**
     * 添加优惠数据
     * @param configType
     * @param configTypeName
     * @param configTypeValue
     * @param configValue
     * @param isStart
     * @return
     */
    @Override
    public boolean insertPrefern(Integer configType, String configTypeName, Integer configTypeValue, String configValue, Integer isStart) {
        return preferentialMapper.addPreferent(configType,configTypeName,configTypeValue,configValue,isStart);
    }

    /**
     * 修改优惠指定数据
     * @param configTypeName
     * @param configValue
     * @param configTypeValue
     * @param isStart
     * @param id
     * @return
     */
    @Override
    public boolean updatPRefen(String configTypeName, String configValue, Integer configTypeValue, Integer isStart, Integer id){
        return preferentialMapper.updatPrefrent(configTypeName,configValue,configTypeValue,isStart,id);
    }

    @Override
    public boolean dledtPreern(Integer id) {
        return preferentialMapper.dletet(id);
    }
}
