package cm.agency.controller;

import cm.agency.entity.as_role;
import cm.agency.service.impl.RoleMapperServiceimpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private RoleMapperServiceimpl roleMapperServiceimpl;
    public RoleMapperServiceimpl getRoleMapperServiceimpl() {
        return roleMapperServiceimpl;
    }

    public void setRoleMapperServiceimpl(RoleMapperServiceimpl roleMapperServiceimpl) {
        this.roleMapperServiceimpl = roleMapperServiceimpl;
    }

    /**
     * 查询所有的角色或根据id查询
     * @param
     * @param
     * @return
     */
    @RequestMapping("rolemanage/get")
    public @ResponseBody String GetRoleAllCurd(Integer page, Integer limit){
        page= (page - 1) *limit ;
        List<as_role> as_roles=roleMapperServiceimpl.GetRoleAlldao(page,limit);
        int count = roleMapperServiceimpl.count();
        //用json来传值
        JSONArray json = JSONArray.fromObject(as_roles);
        String js = json.toString();
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }
    /**
     * 添加角色
     * @param as_role
     * @param
     * @return
     */
    @RequestMapping("rolemanage/add")
    public String addRoleCurd(as_role as_role,HttpSession HttpSession) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        Date Dates=df.parse(datetime);
        as_role.setCreationTime(Dates);
        if(roleMapperServiceimpl.addRoledao(as_role)>0){
            HttpSession.setAttribute("show01","1");
            return "redirect:/jsp/RoleManage.jsp";
        }else {
            HttpSession.setAttribute("show01","0");
            return "RoleManage";
        }
    }

    /**
     * 根据id修改角色消息
     * @param as_role
     * @param model
     * @return
     */
    @RequestMapping("rolemanage/upd")
    public String updRoleCurd(as_role as_role,Model model) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        Date Dates=df.parse(datetime);
        as_role.setLastUpdateTime(Dates);
        if(roleMapperServiceimpl.updRoledao(as_role)>0){
            return "redirect:/jsp/RoleManage.jsp";
        }else {
            return "RoleManage";
        }
    }

    /**
     * 根据id删除角色信息
     * @param id
     * @return
     */
    @RequestMapping("rolemanage/del")
    public @ResponseBody String delRoleCurd(@RequestParam("id")int id){
        Map<String,String> Stringmap=new HashMap<String, String>();
        if (roleMapperServiceimpl.delRoledao(id)>0){
            Stringmap.put("dates","true");

        }else {
            Stringmap.put("dates","false");
        }
        return com.alibaba.fastjson.JSONArray.toJSONString(Stringmap);
    }

}
