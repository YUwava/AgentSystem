package cm.agency.controller;


import cm.agency.entity.As_accountdetailEntity;
import cm.agency.service.impl.Report_typeimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 *报表
 */
@Service
@RequestMapping("yyer")
public class Report_typeController {
    @Autowired
    private Report_typeimpl report_typeimpl;

    public void setReport_typeimpl(Report_typeimpl report_typeimpl) {
        this.report_typeimpl = report_typeimpl;
    }

    @RequestMapping("/eamle")
    @ResponseBody
    public List<As_accountdetailEntity> srrvoer(@RequestParam("quiz") int name, ModelAndView modelAndView){
        /**
         * 代理商账户余额报表
         */
        if(name==0){
            return (report_typeimpl.Report_Severice());
        }else if(name==1){


        }else if(name==2){


        }
        return null;
    }

}
