package cm.agency.service.impl;

import cm.agency.dao.Years_typeMapper;
import cm.agency.service.YearsSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Yearsimpl implements YearsSevrice {
    @Autowired
    private Years_typeMapper years_typeMapper;

    public void setYears_typeMapper(Years_typeMapper years_typeMapper) {
        this.years_typeMapper = years_typeMapper;
    }

    @Override
    public boolean YearInset(Integer configType, String configTypeName, String configValue, Integer isStart) {
        return years_typeMapper.YserInsert(configType,configTypeName,configValue,isStart);
    }
}
