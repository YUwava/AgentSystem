package cm.agency.controller;

import cm.agency.service.impl.Yearsimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequestMapping("/userinst")
public class Years_controller {
    @Autowired
    private Yearsimpl yearsimpl;
    public void setYearsimpl(Yearsimpl yearsimpl) {
        this.yearsimpl = yearsimpl;
    }
    @RequestMapping("/inset")
    public ModelAndView insert(@RequestParam("TyepSever") String TyepSever, @RequestParam("year") String year , ModelAndView modelAndView){
        int configType=3;
        Integer isStart=1;
        System.out.println(TyepSever);
        System.out.println(year);
        if (yearsimpl.YearInset(configType,TyepSever,year,isStart)){
            modelAndView.addObject("dlet","添加成功");
            modelAndView.setViewName("Types_type");
        }else {
            modelAndView.addObject("dlet","添加失败");
            modelAndView.setViewName("Types_type");
        }
        return modelAndView;
    }
}
