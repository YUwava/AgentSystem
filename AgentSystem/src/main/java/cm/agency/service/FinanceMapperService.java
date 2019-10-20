package cm.agency.service;

import cm.agency.entity.as_accountDetail;
import cm.agency.entity.as_systemconfig;
import cm.agency.entity.as_user;

import java.util.List;

public interface FinanceMapperService {
    /**
     * 查询所有的用户
     * @return
     */
    public List<as_user> GetUserAllService()throws Exception;

    /**
     * 查询所有的SystemconfigAll
     * @return
     */
    public List<as_systemconfig> GetSystemconfigAllService()throws Exception;

    /**
     *
     * @param
     * @return
     */
    public  int addAs_accountDetailService(as_accountDetail as_accountDetails)throws Exception;
}
