package cm.agency.service;

import cm.agency.entity.AccountDetail;
import cm.agency.entity.SystemConfig;
import cm.agency.entity.as_user;

import java.util.List;

/**
 * 报表管理业务接口
 */

public interface ReportFormService {

    /**
     * 代理商余额查询
     */
    List<as_user> GetAgentBalance();

    /**
     * 预付款、代理商流水报表
     * @return
     */
    List<AccountDetail> GetPayment();

    /**
     * 产品分类数量/金额总汇
     */
    List<SystemConfig> Totalsummoney();

}
