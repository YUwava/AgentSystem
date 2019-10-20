package cm.agency.controller;


import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.impl.Customer_typeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("CuseroNtroller")
public class Customer_typeContller {
    @Autowired
    private Customer_typeServiceImpl customer_typeServiceImpl;

    public void setCustomer_typeServiceImpl(Customer_typeServiceImpl customer_typeServiceImpl) {
        this.customer_typeServiceImpl = customer_typeServiceImpl;
    }

    /**
     * 显示客户数据
     * @return
     */
    @RequestMapping("/get_Cuser")
    @ResponseBody
    public List<as_systemconfigEntity> selctterCuser(){
        return  customer_typeServiceImpl.selectCustomer();
    }

    /**
     * 添加客户信息
     * @param type
     * @param enabled
     * @param modelAndView
     * @return
     */
    @RequestMapping("/typeinserty")
    public ModelAndView FinaceAdd(@RequestParam("type")String type, @RequestParam("enabled")Integer enabled, ModelAndView modelAndView){
        System.out.println(type+enabled);
        if(type.length()>0){
            Integer configType=5;
            if (customer_typeServiceImpl.AddsCustome_typeService(configType,type,enabled)){
                modelAndView.setViewName("redirect:/jsp/Customer_type.jsp");
            }else {
                modelAndView.addObject("finay",customer_typeServiceImpl.selectCustomer());
                modelAndView.addObject("dlet","添加客户失败");
                modelAndView.setViewName("/Customer_type");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","添加客户失败");
            modelAndView.setViewName("/Customer_type");
        }
        return  modelAndView;
    }

    /**
     * 修改客户数据
     * @param name
     * @param isStar
     * @param finid
     * @param modelAndView
     * @return
     */
    @RequestMapping("/updatCustome_typeServices")
    public  ModelAndView updatCustome_typeService(@RequestParam("type")String name,@RequestParam("enabled")int isStar,
                                     @RequestParam("finid") Integer finid, ModelAndView modelAndView){
        if(name.length()>0){
            if (customer_typeServiceImpl.updatCustome_typeService(name,isStar,finid)){
                modelAndView.setViewName("redirect:/jsp/Customer_type.jsp");
            }else {
                modelAndView.addObject("finay",customer_typeServiceImpl.selectCustomer());
                modelAndView.addObject("dlet","更新失败");
                modelAndView.setViewName("/Customer_type");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","客户数据更新失败");
            modelAndView.setViewName("/Customer_type");
        }
        return modelAndView;
    }

    /**
     * 删除客户数据
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping("/deleteCustomes")
    public  ModelAndView deleteCustome(@RequestParam("id")Integer id, ModelAndView modelAndView){
        System.out.println(id);
        if (customer_typeServiceImpl.delteCustome_type(id)){
            modelAndView.setViewName("redirect:/jsp/Customer_type.jsp");
        }else {
            modelAndView.addObject("finay",customer_typeServiceImpl.selectCustomer());
            modelAndView.addObject("dlet","删除失败");
            modelAndView.setViewName("Customer_type");
        }
        return  modelAndView;
    }
}
