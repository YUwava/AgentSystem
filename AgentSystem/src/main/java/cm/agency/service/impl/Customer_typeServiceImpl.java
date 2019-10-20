package cm.agency.service.impl;

import cm.agency.dao.Customer_typeMapper;
import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.Customer_typeService;
import cm.agency.service.Service_TypeSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Customer_typeServiceImpl implements Customer_typeService {
    @Autowired
    private Customer_typeMapper customer_typeMapper;

    public void setCustomer_typeMapper(Customer_typeMapper customer_typeMapper) {
        this.customer_typeMapper = customer_typeMapper;
    }
    /**
     * 所有客户数据
     * @return
     */
    @Override
    public List<as_systemconfigEntity> selectCustomer(){
        return customer_typeMapper.SelectCustomer();
    }

    @Override
    public boolean AddsCustome_typeService(Integer configType, String configTypeName, Integer isStart) {
        return customer_typeMapper.insertCustomer(configType,configTypeName,isStart);
    }

    @Override
    public boolean updatCustome_typeService(String configTypeName, Integer isStart, Integer id) {
        return customer_typeMapper.updatCuserome(configTypeName,isStart,id);
    }

    @Override
    public boolean delteCustome_type(Integer id) {
        return customer_typeMapper.deleteCuserome(id);
    }
}
