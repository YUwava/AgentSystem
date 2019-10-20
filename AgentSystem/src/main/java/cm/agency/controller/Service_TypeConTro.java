package cm.agency.controller;


import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.impl.Service_Typeimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("Tyep_service")
public class Service_TypeConTro {
    @Autowired
    private Service_Typeimpl service_typeimpl;

    public void setService_typeimpl(Service_Typeimpl service_typeimpl) {
        this.service_typeimpl = service_typeimpl;
    }

    /**
     * 服务类型数据
     * @return
     */
    @RequestMapping("/service_type")
    @ResponseBody
    public List<as_systemconfigEntity> ServiceSelecct(){
        return  service_typeimpl.ServiceSelect();
    }

    /**
     * 添加服务类型数据
     * @param type
     * @param numerical_value
     * @param enabled
     * @param modelAndView
     * @return
     */
    @RequestMapping("/typeinserty")
    public ModelAndView FinaceAdd(@RequestParam("type")String type,
                                  @RequestParam("numerical_value")Integer numerical_value,
                                  @RequestParam("enabled")Integer enabled,
                                  ModelAndView modelAndView){
        if(type.length()>0 && numerical_value>0){

            Integer configType=2;
            System.out.println(configType+type+numerical_value+enabled);
            if (service_typeimpl.ServiceCeAdd_type(configType,type,numerical_value,enabled)){
                modelAndView.setViewName("redirect:/jsp/Service_type.jsp");
            }else {
                modelAndView.addObject("finay",service_typeimpl.ServiceSelect());
                modelAndView.addObject("dlet","添加服务类型失败");
                modelAndView.setViewName("/Service_type");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","添加服务类型失败");
            modelAndView.setViewName("/Service_type");
        }
        return  modelAndView;
    }

    /**
     * 修改指定数据
     * @param type
     * @param numerical_value
     * @param enabled
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping("/updat_Finas")
    public  ModelAndView updatFina(@RequestParam("type")String type,
                                   @RequestParam("numerical_value")Integer numerical_value,
                                   @RequestParam("enabled")Integer enabled,
                                   @RequestParam("finid")Integer id,
                                   ModelAndView modelAndView){
        if(type.length()>0 && numerical_value>0 && enabled>0){
            if (service_typeimpl.updatSerice(type,numerical_value,enabled,id)){
                modelAndView.setViewName("redirect:/jsp/Service_type.jsp");
            }else {
                modelAndView.addObject("finay",service_typeimpl.ServiceSelect());
                modelAndView.addObject("dlet","修改服务类型失败");
                modelAndView.setViewName("/service_type");
            }
            return  modelAndView;

        }else {
            modelAndView.addObject("dlet","修改服务类型失败");
            modelAndView.setViewName("/Service_type");
        }
        return  modelAndView;
    }
}
