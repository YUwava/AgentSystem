package cm.agency.controller;

import cm.agency.entity.as_Keywords;
import cm.agency.entity.as_role_premission;
import cm.agency.service.impl.RoleJurisdictionMapperServiceimpl;
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
public class RoleJurisdictionController {
    @Autowired
    private RoleJurisdictionMapperServiceimpl roleJurisdictionMapperServiceimpl;
    public RoleJurisdictionMapperServiceimpl getRoleJurisdictionMapperServiceimpl() {
        return roleJurisdictionMapperServiceimpl;
    }

    public void setRoleJurisdictionMapperServiceimpl(RoleJurisdictionMapperServiceimpl roleJurisdictionMapperServiceimpl) {
        this.roleJurisdictionMapperServiceimpl = roleJurisdictionMapperServiceimpl;
    }

    /**
     * 查询所有的角色
     * @param model
     * @return
     */
    @RequestMapping("RoleJurisdiction/role/get")
    public String GETRoleJurisdictionCurd(Model model){
        model.addAttribute("rolelist",roleJurisdictionMapperServiceimpl.GetRoleService());
        return "RoleJurisdiction";
    }

    /**
     * 根据role 查询
     * @param roleId
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("GetroleJurisdiction/get.json")
    public @ResponseBody Map<String,Object> GetroleJurisdictionCurd(@RequestParam(required = false,value = "roleId") int roleId,
                                                                    @RequestParam(value = "page") Integer page,
                                                                    @RequestParam(value = "limit")Integer limit) throws Exception {
        page= (page - 1) *limit ;
        List<as_role_premission> as_role_premission=roleJurisdictionMapperServiceimpl.GetRoleJurisdictionAllingdao(roleId,page,limit);
        int count = roleJurisdictionMapperServiceimpl.counts(roleId);
        Map<String,Object> map = new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",count);
        map.put("data",as_role_premission);
        return map;
    }
    @RequestMapping("updisStart/upd")
    public @ResponseBody String updJurisdictionisstartCurd(@RequestParam("id")int id, @RequestParam("isStart")int isStart){
        Map<String,String> Stringmap=new HashMap<String, String>();
        if(roleJurisdictionMapperServiceimpl.updRoleJurisdictionidService(id,isStart)>0){
            Stringmap.put("itmes","true");
        }else{
            Stringmap.put("itmes","false");
        }
        return JSONArray.toJSONString(Stringmap);
    }
}
