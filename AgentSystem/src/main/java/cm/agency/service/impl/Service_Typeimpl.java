package cm.agency.service.impl;

import cm.agency.dao.Service_TypeMapper;
import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.Service_TypeSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Typeimpl implements Service_TypeSevrice {
    @Autowired
    private Service_TypeMapper service_typeMapper;

    public void setService_typeMapper(Service_TypeMapper service_typeMapper) {
        this.service_typeMapper = service_typeMapper;
    }

    /**
     * 服务类型数据
     * @return
     */
    @Override
    public List<as_systemconfigEntity> ServiceSelect() {
        return service_typeMapper.ServiceSelect();
    }

    /**
     * 添加
     * @param configType
     * @param configTypeName
     * @param configValue
     * @param isStart
     * @return
     */
    @Override
    public boolean ServiceCeAdd_type(Integer configType, String configTypeName, Integer configValue, Integer isStart) {
        return service_typeMapper.ServiceCeAdd(configType,configTypeName,configValue,isStart);
    }

    /**
     * 修改指定数据
     * @param configValue
     * @param configTypeName
     * @param isStart
     * @param id
     * @return
     */
    @Override
    public boolean updatSerice(String configValue, Integer configTypeName, Integer isStart, Integer id) {
        return service_typeMapper.updatService(configValue,configTypeName,isStart,id);
    }


}
