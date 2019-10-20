package cm.agency.service.impl;

import cm.agency.dao.AppIdMapper;
import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.AppidSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Appidimpl implements AppidSevrice {
    @Autowired
   private AppIdMapper appIdMapper;

    public void setAppIdMapper(AppIdMapper appIdMapper) {
        this.appIdMapper = appIdMapper;
    }

    @Override
    public List<as_systemconfigEntity> appselect() {
        return appIdMapper.sletcy();
    }

    @Override
    public boolean appids(String configValue, Integer id) {
        return appIdMapper.appInsert(configValue,id);
    }


}
