package cm.agency.service;

import cm.agency.entity.as_role;
import cm.agency.entity.as_user;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserMapperService {
    /**
     * 查询指点用户
     * @return as_user
     */
    public List<as_user> GetUserAccountAndPwdService(String userCode, String userpwd);


    /**
     * 查询所有的角色
     * @return
     */
    public List<as_user> GetUserroleAllService();

    /**
     * 查询【所有的角色
     * @return
     */
    public List<as_role> GetRolesAllService();

    /**
     * 根据条件查询用户信息
     * @return
     */
    public List<as_user> GetUserconditionAllService(int before, int after)throws Exception;
    public int counts()throws Exception;

    public List<as_user> GetUserconditionAllingdao(String userName,Integer roleId, int isStart, int before, int after);
    public int counting(String userName,int roleId, int isStart);

    /**
     * 提交用户
     * @param as_user
     * @return
     */
    public int addUserdaoService(as_user as_user);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delUserService(int id);

    /**
     * 修改用户
     * @param as_user
     * @return
     */
    public int updUserService(as_user as_user);

    public int GetoldService(int id,String pwd);

    /**
     * 修改密码
     * @param id
     * @param pwd
     * @return
     */
    public int updPwdService(int id,String pwd);
}
