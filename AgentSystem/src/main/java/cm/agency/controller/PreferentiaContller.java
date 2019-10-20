package cm.agency.controller;

import cm.agency.dao.PreferentialMapper;
import cm.agency.entity.as_systemconfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@RequestMapping("Preferne")
public class PreferentiaContller {
    @Autowired
    private PreferentialMapper preferentialMapper;

    public void setPreferentialMapper(PreferentialMapper preferentialMapper) {
        this.preferentialMapper = preferentialMapper;
    }

    /**
     * 所有数据
     * @return
     */
    @RequestMapping("/get_Preferne")
    @ResponseBody
    public List<as_systemconfigEntity> FinanceShowss(){
        return  preferentialMapper.SelectPreferent();
    }

    /**
     * 添加优惠数据
     * @param
     * @param modelAndView
     * @return
     */
    @RequestMapping("/inserty")
    public ModelAndView AddPreferen(@RequestParam(value = "configTypeName",required=false)String configTypeName,
                                    @RequestParam(value="configTypeValue",required=false)Integer configTypeValue,
                                    @RequestParam(value="configValue",required=false)String configValue,
                                    @RequestParam(value="isStart",required=false)Integer isStart,ModelAndView modelAndView){
        System.out.println(configTypeName+"----"+configTypeValue+"----"+configValue);
        if(configTypeName.length()>0 && configTypeValue>0 && configValue.length()>0){

            Integer a=7;
            if (preferentialMapper.addPreferent(a,configTypeName,configTypeValue,configValue,isStart)){
                modelAndView.setViewName("redirect:/jsp/Preferential_Type.jsp");
            }else {
                modelAndView.addObject("finay",preferentialMapper.SelectPreferent());
                modelAndView.addObject("dlet","添加优惠失败");
                modelAndView.setViewName("/Preferential_Type");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","添加优惠失败");
            modelAndView.setViewName("/Preferential_Type");
        }
        return  modelAndView;
    }

    /**
     * 优惠修改
     * @param configTypeName
     * @param configValue
     * @param configTypeValue
     * @param finid
     * @param modelAndView
     * @return
     */
    @RequestMapping("/updatPreferen")
    public  ModelAndView updatFinace(@RequestParam("type")String configTypeName,@RequestParam("configValue")String configValue,
                                     @RequestParam("configTypeValue") Integer configTypeValue, @RequestParam("enabled")Integer enabled ,
                                     @RequestParam("finid")Integer finid,
                                     ModelAndView modelAndView){
        System.out.println(configTypeName+"----"+configTypeValue+"----"+configValue+"======"+enabled);
        if(configTypeName.length()>0 && configValue.length()>0 && configTypeValue>0){
            if (preferentialMapper.updatPrefrent(configTypeName,configValue,configTypeValue,enabled,finid)){
                modelAndView.setViewName("redirect:/jsp/Preferential_Type.jsp");
            }else {
                modelAndView.addObject("finay",preferentialMapper.SelectPreferent());
                modelAndView.addObject("dlet","修改优惠类型失败");
                modelAndView.setViewName("/Preferential_Type");
            }
            return  modelAndView;
        }else {
            modelAndView.addObject("dlet","修改优惠类型失败");
            modelAndView.setViewName("Preferential_Type");
        }
        return  modelAndView;
    }
    @RequestMapping("/deletePreferen")
    public  ModelAndView deleteCustome(@RequestParam("id")Integer id, ModelAndView modelAndView){
        System.out.println(id);
        if (preferentialMapper.dletet(id)){
            modelAndView.setViewName("redirect:/jsp/Preferential_Type.jsp");
        }else {
            modelAndView.addObject("finay",preferentialMapper.SelectPreferent());
            modelAndView.addObject("dlet","删除失败");
            modelAndView.setViewName("/Preferential_Type");
        }
        return  modelAndView;
    }
}
