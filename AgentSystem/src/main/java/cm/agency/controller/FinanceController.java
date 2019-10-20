package cm.agency.controller;

import cm.agency.entity.as_accountDetail;
import cm.agency.entity.as_systemconfig;
import cm.agency.entity.as_user;
import cm.agency.service.impl.FinanceMapperServiceimpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FinanceController {
    @Autowired
    private FinanceMapperServiceimpl financeMapperServiceimpl;
    public FinanceMapperServiceimpl getFinanceMapperServiceimpl() {
        return financeMapperServiceimpl;
    }

    public void setFinanceMapperServiceimpl(FinanceMapperServiceimpl financeMapperServiceimpl) {
        this.financeMapperServiceimpl = financeMapperServiceimpl;
    }

    /**
     * 查询所有的用户和
     * @param model
     * @return
     */
    @RequestMapping("/Finance/get/user")
    public String GteUserAll(Model model) throws Exception{
        List<as_user> as_users=financeMapperServiceimpl.GetUserAllService();
        List<as_systemconfig> as_systemconfigs=financeMapperServiceimpl.GetSystemconfigAllService();
        model.addAttribute("as_users",as_users);
        model.addAttribute("as_systemconfigs",as_systemconfigs);
        return "FinanceManage";
    }

    /**
     * 财务添加
     * @param
     * @return
     */
    @RequestMapping("Finance/get/add")
    public String AddFinance(as_accountDetail as_accountDetails, HttpSession HttpSession) throws Exception{
        List<as_systemconfig> as_systemconfigs=financeMapperServiceimpl.GetSystemconfigAllService();
        for (as_systemconfig data:as_systemconfigs){
            if(data.getId()==as_accountDetails.getDetailType()){
                as_accountDetails.setDetailTypeName(data.getConfigTypeName());
                break;
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        Date Dates=df.parse(datetime);
        as_accountDetails.setDetailDateTime(Dates);
        as_accountDetails.setMoney(as_accountDetails.getAccountMoney());
        //System.out.println(as_accountDetails.getUserId()+"==="+as_accountDetails.getDetailType()+"==="+as_accountDetails.getDetailDateTime()+"==="+as_accountDetails.getAccountMoney()+"==="+as_accountDetails.getDetailTypeName()+"==="+as_accountDetails.getMemo()+"==="+as_accountDetails.getMoney()+"===");
        if(financeMapperServiceimpl.addAs_accountDetailService(as_accountDetails)>0){
            HttpSession.setAttribute("show","1");
            return "redirect:/Finance/get/user";
        }else {
            HttpSession.setAttribute("show","2");
            return "FinanceManage";
        }
    }

}
