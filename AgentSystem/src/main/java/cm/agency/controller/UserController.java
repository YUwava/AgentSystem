package cm.agency.controller;

import cm.agency.entity.as_role;
import cm.agency.entity.as_user;
import cm.agency.service.impl.FinanceMapperServiceimpl;
import cm.agency.service.impl.UserMapperServiceimpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserMapperServiceimpl userMapperServiceimpl;
    public UserMapperServiceimpl getUserMapperServiceimpl() {
        return userMapperServiceimpl;
    }

    public void setUserMapperServiceimpl(UserMapperServiceimpl userMapperServiceimpl) {
        this.userMapperServiceimpl = userMapperServiceimpl;
    }

    @RequestMapping("UserLogin")
    public String LoginController(@RequestParam("userCode")String userCode,@RequestParam("userPassword")String userpwd,
                                            HttpServletRequest request, HttpSession session){
        List<as_user> as_usering=userMapperServiceimpl.GetUserAccountAndPwdService(userCode,userpwd);
        if(as_usering.size()>0){
            session.setAttribute("user",as_usering.get(0).getUserName());
            session.setAttribute("userids",as_usering.get(0).getId());
            return "HomePages";
        }else {
            return "redirect:/index.jsp";
        }
    }



    /**
     * 查询所有的角色
     * @param model
     * @return
     */
    @RequestMapping("UserRole/get")
    public  String GetUserRoleCurd(Model model){
        List<as_role> as_users=userMapperServiceimpl.GetRolesAllService();
        model.addAttribute("as_users",as_users);
        return "UserManage";
    }

    /**
     * 根据条件查询用户信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "usermanage/get.json")
    public @ResponseBody String GetUserConditionCurd(Integer page,
                                                      Integer limit)throws Exception{
        page= (page - 1) *limit ;
        System.out.println(page + "usermanage" +limit);
        List<as_user> as_users=userMapperServiceimpl.GetUserconditionAllService(page,limit);
        int count = userMapperServiceimpl.counts();
        //用json来传值
        JSONArray json = JSONArray.fromObject(as_users);
        String js = json.toString();
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }

    /**
     * 根据条件查询
     * @param userName
     * @param roleId
     * @param isStart
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "usermanages/get.json" ,method =  RequestMethod.GET)
    public @ResponseBody Map<String,Object> GetUserConditionsCurd(@RequestParam(required = false,value = "userName") String userName,
                                                     @RequestParam(required = false,value = "roleId")  Integer roleId,
                                                     @RequestParam(required = false,value = "isStart") Integer isStart,
                                                      @RequestParam(value = "page") Integer page,
                                                      @RequestParam(value = "limit")Integer limit)throws Exception{
        page= (page - 1) *limit ;
        System.out.println(page + "usermanages" +limit);
        List<as_user> as_users=userMapperServiceimpl.GetUserconditionAllingdao(userName,roleId,isStart,page,limit);
        int count = userMapperServiceimpl.counts();
        Map<String,Object> map = new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",count);
        map.put("data",as_users);
        return map;
    }

    /**
     * 提交用户信息
     * @param as_user
     * @return
     * @throws ParseException
     */
    @RequestMapping("adduser/add")
    public String addUserAllCurd(as_user as_user) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        Date Dates=df.parse(datetime);
        as_user.setCreationTime(Dates);
        if(userMapperServiceimpl.addUserdaoService(as_user)>0){
            return "redirect:/UserRole/get";
        }
        return "redirect:/UserRole/get";
    }

    /**
     * 根据条件删除
     * @param id
     * @return
     */
    @RequestMapping("delUser/del")
    public @ResponseBody String delUserConditionCurd(@RequestParam("id")int id){
        Map<String,String> Stringmap=new HashMap<String, String>();
        if(userMapperServiceimpl.delUserService(id)>0){
            Stringmap.put("dates","true");
        }else {
            Stringmap.put("dates","false");
        }
        return com.alibaba.fastjson.JSONArray.toJSONString(Stringmap);
    }

    /**
     * 修改用户信息
     * @param as_user
     * @return
     */
    @RequestMapping("upduser/upd")
    public String updUserCurd(as_user as_user) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String datetime=df.format(new Date());
        Date Dates=df.parse(datetime);
        as_user.setLastUpdateTime(Dates);
        if(userMapperServiceimpl.updUserService(as_user)>0){
            return "redirect:/UserRole/get";
        }
        return "redirect:/UserRole/get";
    }

    /**
     * 查询旧密码是否存在
     * @param id
     * @param pwd
     * @return
     */
    @RequestMapping("getpwd/get")
    public @ResponseBody String GetoldPwdCurd(@RequestParam("id")int id,@RequestParam("pwd")String pwd){
        Map<String,String> StringMap=new HashMap<String, String>();
        if (userMapperServiceimpl.GetoldService(id,pwd)>0){
            StringMap.put("itmes","true");
        }else {
            StringMap.put("itmes","false");
        }
        return com.alibaba.fastjson.JSONArray.toJSONString(StringMap);
    }

    /**
     * 修改密码
     * @param id
     * @param pwd
     * @return
     */
    @RequestMapping("getpwd/updPwd")
    public @ResponseBody String updoldPwdCurd(@RequestParam("id")int id,@RequestParam("pwd")String pwd){
        Map<String,String> StringMap=new HashMap<String, String>();
        if (userMapperServiceimpl.updPwdService(id,pwd)>0){
            StringMap.put("itmeing","true");
        }else {
            StringMap.put("itmeing","false");
        }
        return com.alibaba.fastjson.JSONArray.toJSONString(StringMap);
    }

}
