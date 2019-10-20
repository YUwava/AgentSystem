
package cm.agency.controller;


import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.impl.As_systemconfigServiceimpl;
import com.mysql.jdbc.MysqlIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("figcontroller")
public class Distribution_Systemconfig {
    @Autowired
    private As_systemconfigServiceimpl as_systemconfigServiceimp;

    public void setAs_systemconfigServiceimp(As_systemconfigServiceimpl as_systemconfigServiceimp) {
        this.as_systemconfigServiceimp = as_systemconfigServiceimp;
    }
    /**
     * 财务显示数据
     * @param
     * @return
     */
//    @RequestMapping("/show")
//    public  String FinanceShow(Model model){
//        model.addAttribute("finay",as_systemconfigServiceimp.FinanceShow());
//        return  "Finance";
//    }
    @RequestMapping("/get_figlist")
    @ResponseBody
    public  List<as_systemconfigEntity> FinanceShowss(){
//        model.addAttribute("finay",);
        return  as_systemconfigServiceimp.FinanceShow();
    }
    /**
     *财务 添加操作
     * @param type
     * @param enabled
     * @return
     */
    @RequestMapping("/typeinserty")
    public ModelAndView FinaceAdd(@RequestParam("type")String type, @RequestParam("enabled")Integer enabled,ModelAndView modelAndView){
        if(type.length()>0){
            Integer configType=1;
            if (as_systemconfigServiceimp.FinanceAdds(configType,type,enabled)){
                modelAndView.setViewName("redirect:/jsp/Finance.jsp");
            }else {
                modelAndView.addObject("finay",as_systemconfigServiceimp.FinanceShow());
                modelAndView.addObject("dlet","账务类型添加失败");
                modelAndView.setViewName("/Finance");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","账务类型添加失败");
            modelAndView.setViewName("/Finance");
            return  modelAndView;
        }
    }

    /**
     * 财务修改
     * @param name
     * @param isStar
     * @param modelAndView
     * @return
     */
    @RequestMapping("/updatFian")
    public  ModelAndView updatFinace(@RequestParam("type")String name,@RequestParam("enabled")int isStar,
                                     @RequestParam("finid") Integer finid, ModelAndView modelAndView){
        System.out.println(name);
        System.out.println(isStar);
        System.out.println(finid);
        if(name.length()>0){
            if (as_systemconfigServiceimp.updatFinace(name,isStar,finid)){
                modelAndView.setViewName("redirect:/jsp/Finance.jsp");
            }else {
                modelAndView.addObject("finay",as_systemconfigServiceimp.FinanceShow());
                modelAndView.addObject("dlet","修改配置类型失败");
                modelAndView.setViewName("/Finance");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","修改配置类型失败");
            modelAndView.setViewName("/Finance");
            return modelAndView;
        }
    }
    @RequestMapping("/delete")
    public  ModelAndView deleteFinace(@RequestParam("id")Integer id, ModelAndView modelAndView){
        System.out.println(id);
        if (as_systemconfigServiceimp.delteFiance(id)){
            modelAndView.setViewName("redirect:/jsp/Finance.jsp");
        }else {
            modelAndView.addObject("finay",as_systemconfigServiceimp.FinanceShow());
            modelAndView.addObject("dlet","删除失败");
            modelAndView.setViewName("delete");
        }
        return  modelAndView;
    }
}
