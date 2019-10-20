package cm.agency.dao;

import cm.agency.entity.as_accountDetail;
import cm.agency.entity.as_systemconfig;
import cm.agency.entity.as_user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceMapper {
    /**
     * 查询所有的用户
     * @return
     */
    public List<as_user> GetUserAlldao()throws Exception;

    /**
     * 查询所有的SystemconfigAll
     * @return
     */
    public List<as_systemconfig> GetSystemconfigAlldao()throws Exception;

    /**
     * 添加财务管理
     * @return
     */
    public  int addAs_accountDetaildao(as_accountDetail as_accountDetails)throws Exception;

}
