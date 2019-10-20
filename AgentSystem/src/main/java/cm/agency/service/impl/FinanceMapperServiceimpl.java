package cm.agency.service.impl;

import cm.agency.dao.FinanceMapper;
import cm.agency.entity.as_accountDetail;
import cm.agency.entity.as_systemconfig;
import cm.agency.entity.as_user;
import cm.agency.service.FinanceMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service("financeMapperService")
public class FinanceMapperServiceimpl implements FinanceMapperService {
    @Autowired
    private FinanceMapper financeMapper;
    public FinanceMapper getFinanceMapper() throws Exception{
        return financeMapper;
    }

    public void setFinanceMapper(FinanceMapper financeMapper) throws Exception{
        this.financeMapper = financeMapper;
    }

    @Override
    public List<as_user> GetUserAllService() throws Exception{
        return financeMapper.GetUserAlldao();
    }

    @Override
    public List<as_systemconfig> GetSystemconfigAllService() throws Exception{
        return financeMapper.GetSystemconfigAlldao();
    }

    @Override
    public int addAs_accountDetailService(as_accountDetail as_accountDetails) throws Exception{
        return financeMapper.addAs_accountDetaildao(as_accountDetails);
    }
}
