
package cm.agency.service.impl;

import cm.agency.dao.As_systemconfigMapper;
import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.As_systemconfigSevricee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class As_systemconfigServiceimpl implements As_systemconfigSevricee {
    //基础财务As_systemconfigSevricee  的接口内的方法
    @Autowired
    private As_systemconfigMapper as_systemconfigMapper;

    public void setAs_systemconfigMapper(As_systemconfigMapper as_systemconfigMapper) {
        this.as_systemconfigMapper = as_systemconfigMapper;
    }
    @Override
    public List<as_systemconfigEntity> FinanceShow() {
        return as_systemconfigMapper.FinanceShow();
    }

    @Override
    public boolean FinanceAdds(Integer configType, String configTypeName, Integer isStart) {
        return as_systemconfigMapper.FinanceAdd(configType,configTypeName,isStart);
    }

    @Override
    public boolean updatFinace(String configTypeName, Integer isStart, Integer id) {
        return as_systemconfigMapper.updater(configTypeName,isStart,id);
    }

    @Override
    public boolean delteFiance(Integer id) {
        return as_systemconfigMapper.delete(id);
    }

}
