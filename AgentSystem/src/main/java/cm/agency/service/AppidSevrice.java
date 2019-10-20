package cm.agency.service;

import cm.agency.entity.as_systemconfigEntity;

import java.util.List;

public interface AppidSevrice {

    public List<as_systemconfigEntity> appselect();

    public  boolean appids(String configValue,Integer id);
}
