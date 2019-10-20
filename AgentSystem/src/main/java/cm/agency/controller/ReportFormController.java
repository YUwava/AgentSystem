package cm.agency.controller;

import cm.agency.entity.AccountDetail;
import cm.agency.entity.SystemConfig;
import cm.agency.entity.as_user;
import cm.agency.service.ReportFormService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "reportform")
public class ReportFormController {

    @Resource
    private ReportFormService reportFormService;

    /**
     * JSON     报表查询
     */
    @RequestMapping(value = "GetAdministrationList")
    @ResponseBody
    public List<as_user> GetAdministrationList(){
        List<as_user> userList = new ArrayList<>();         //代理商余额查询  or  预付款、代理商流水报表
        userList = reportFormService.GetAgentBalance();//代理商余额查询
        return userList;
    }

    /**
     * JSON     报表查询
     */
    @RequestMapping(value = "GetPayment")
    @ResponseBody
    public List<AccountDetail> GetPayment(){
        List<AccountDetail> accountDetailList = new ArrayList<>();         //预付款、代理商流水报表
        accountDetailList = reportFormService.GetPayment();
        return accountDetailList;
    }

    /**
     * JSON     报表查询
     */
    @RequestMapping(value = "Totalsummoney")
    @ResponseBody
    public List<SystemConfig> Totalsummoney(){
        List<SystemConfig> systemConfigList = new ArrayList<>();         //产品分类数量/金额总汇
        systemConfigList = reportFormService.Totalsummoney();
        return systemConfigList;
    }
}
