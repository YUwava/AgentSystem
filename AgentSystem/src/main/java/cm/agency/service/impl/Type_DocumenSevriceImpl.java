package cm.agency.service.impl;

import cm.agency.dao.Type_DocumentMapper;
import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.Type_DocumenSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Type_DocumenSevriceImpl implements Type_DocumenSevrice {
    @Autowired
    private Type_DocumentMapper type_DocumentMapper;

    public void setType_DocumentMapper(Type_DocumentMapper type_DocumentMapper) {
        this.type_DocumentMapper = type_DocumentMapper;
    }

    /**
     * 证件所有数据
     * @return
     */
    @Override
    public List<as_systemconfigEntity> selectCustomer() {
        return type_DocumentMapper.selectDocumentMapper();
    }

    /**
     * 添加证件
     * @param configType
     * @param configTypeName
     * @param isStart
     * @return
     */
    @Override
    public boolean AddsDocument(Integer configType, String configTypeName, Integer isStart) {
        return type_DocumentMapper.AddDocument(configType,configTypeName,isStart);
    }

    @Override
    public boolean updatDocument(String configTypeName, Integer isStart, Integer id) {
        return type_DocumentMapper.updatDocument(configTypeName,isStart,id);
    }

    @Override
    public boolean delteDocument(Integer id) {
        return type_DocumentMapper.deleteDocument(id);
    }
}
