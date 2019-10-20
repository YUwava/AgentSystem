package cm.agency.controller;

import cm.agency.entity.as_systemconfigEntity;
import cm.agency.service.impl.Type_DocumenSevriceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@RequestMapping("Type_DocunCon")
public class Type_DocumenContller {
    @Autowired
    private Type_DocumenSevriceImpl Type_DocumenSevriceImpl;

    /**
     * 证件所数据
     * @return
     */
    @RequestMapping("/get_DocunCon")
    @ResponseBody
    public List<as_systemconfigEntity> selctterDocunCon(){
        return  Type_DocumenSevriceImpl.selectCustomer();
    }

    /**
     * 添加证件
     * @param type
     * @param enabled
     * @param modelAndView
     * @return
     */
    @RequestMapping("/InsertyDocunCon")
    public ModelAndView AddDocunCon(@RequestParam("type")String type, @RequestParam("enabled")Integer enabled, ModelAndView modelAndView){
        System.out.println(type+enabled);
        if(type.length()>0 && enabled>0){

            Integer configType=6;
            if (Type_DocumenSevriceImpl.AddsDocument(configType,type,enabled)){
                modelAndView.setViewName("redirect:/jsp/Type_Document.jsp");
            }else {
                modelAndView.addObject("finay",Type_DocumenSevriceImpl.selectCustomer());
                modelAndView.addObject("dlet","证件添加失败");
                modelAndView.setViewName("Type_Document");
            }
            return  modelAndView;
        } else {
            modelAndView.addObject("dlet","证件添加失败");
            modelAndView.setViewName("/Type_Document");
        }
        return  modelAndView;
    }

    /**
     * 修改证件数据
     * @param name
     * @param isStar
     * @param finid
     * @param modelAndView
     * @return
     */
    @RequestMapping("/updatDocunCon")
    public  ModelAndView updatCustome_typeService(@RequestParam("type")String name,@RequestParam("enabled")Integer isStar,
                                                  @RequestParam("finid") Integer finid, ModelAndView modelAndView){
        if(name.length()>0 && isStar>0 && finid>0){

            if (Type_DocumenSevriceImpl.updatDocument(name,isStar,finid)){
                modelAndView.setViewName("redirect:/jsp/Type_Document.jsp");
            }else {
                modelAndView.addObject("finay",Type_DocumenSevriceImpl.selectCustomer());
                modelAndView.addObject("dlet","更新证件失败");
                modelAndView.setViewName("Type_Document");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","更新证件失败");
            modelAndView.setViewName("/Type_Document");
        }
        return  modelAndView;
    }

    @RequestMapping("/delete")
    public  ModelAndView deleteFinace(@RequestParam("id")Integer id, ModelAndView modelAndView){
        System.out.println(id);
        if (Type_DocumenSevriceImpl.delteDocument(id)){
            modelAndView.setViewName("redirect:/jsp/Type_Document.jsp");
        }else {
            modelAndView.addObject("finay",Type_DocumenSevriceImpl.selectCustomer());
            modelAndView.addObject("dlet","删除失败");
            modelAndView.setViewName("delete");
        }
        return  modelAndView;
    }

}
