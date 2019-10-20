package cm.agency.controller;

import cm.agency.entity.as_Keywords;
import cm.agency.entity.as_user;
import cm.agency.service.impl.AntistopAuditServiceimpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class AntistopAuditController {
    @Autowired
    private AntistopAuditServiceimpl antistopAuditServiceimpl;
    public AntistopAuditServiceimpl getAntistopAuditServiceimpl() {
        return antistopAuditServiceimpl;
    }

    public void setAntistopAuditServiceimpl(AntistopAuditServiceimpl antistopAuditServiceimpl) {
        this.antistopAuditServiceimpl = antistopAuditServiceimpl;
    }
    @RequestMapping("AntistopAuditAll/get")
    public String GetAntistopAuditAllCurd(Model model){
        model.addAttribute("keyWords" ,antistopAuditServiceimpl.GetKeyWordsAllDao());
        return  "AntistopAudit";
    }
    /**
     *  根据条件查询关键词信息
     * @param keywords
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("AntistopAudit/get.json")
    public @ResponseBody Map<String,Object> GetAntistopAuditCurd(@RequestParam(required = false,value = "keywords") String keywords,
                                                     @RequestParam(value = "page") Integer page,
                                                     @RequestParam(value = "limit")Integer limit)throws Exception{
        page= (page - 1) *limit ;
        List<as_Keywords> as_Keywordss=antistopAuditServiceimpl.GetKeyWordsDao(keywords,page,limit);
        int count = antistopAuditServiceimpl.counts();
        Map<String,Object> map = new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",count);
        map.put("data",as_Keywordss);
        return map;
    }

    /**
     * 根据prices修改关键词
     * @param id
     * @param prices
     * @return
     */
    @RequestMapping("updkeywordscondition/upd")
    public @ResponseBody String updkeywordsconditionCurd(@RequestParam("id")int id,@RequestParam("prices")int prices){
        Map<String,String> StringMap=new HashMap<String, String>();
        if (antistopAuditServiceimpl.updkeywordsConditionDao(id,prices)>0){
            StringMap.put("itmes","true");
        }else {
            StringMap.put("itmes","false");
        }
        return JSONArray.toJSONString(StringMap);
    }
    @RequestMapping("KeyWords/date/upd")
    public String updkeywordsconddateCurd(@RequestParam("id")int id,@RequestParam("regPassDatetime")int regPassDatetime){
        Map<String,String> StringMap=new HashMap<String, String>();
        if (antistopAuditServiceimpl.updkeywordsrenew(id,regPassDatetime)>0){
            return "redirect:/AntistopAuditAll/get";
        }
        return "redirect:/AntistopAuditAll/get";
    }

}
