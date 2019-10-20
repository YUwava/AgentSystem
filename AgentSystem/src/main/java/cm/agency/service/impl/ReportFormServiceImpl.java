package cm.agency.service.impl;


import cm.agency.dao.ReportFormMapper;
import cm.agency.entity.AccountDetail;
import cm.agency.entity.SystemConfig;
import cm.agency.entity.as_user;
import cm.agency.service.ReportFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报表的业务接口实现类
 */

@Service
public class ReportFormServiceImpl implements ReportFormService {

    @Resource
    private ReportFormMapper reportFormMapper;

    /**
     * 代理商余额查询
     */
    public List<as_user> GetAgentBalance() {
        return reportFormMapper.GetAgentBalance();
    }

    /**
     * 预付款、代理商流水报表
     * @return
     */
    public List<AccountDetail> GetPayment() {
        return reportFormMapper.GetPayment();
    }

    /**
     * 产品分类数量/金额总汇
     */
    public List<SystemConfig> Totalsummoney() {
        return reportFormMapper.Totalsummoney();
    }
}
