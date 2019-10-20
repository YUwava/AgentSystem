package cm.agency.dao;

import cm.agency.entity.as_role;
import cm.agency.entity.as_user;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

    /**
     * 查询指点用户
     * @return as_user
     */
    public List<as_user> GetUserAccountAndPwddao(@Param("userCode") String userCode, @Param("userPassword") String userPassword);


    /**
     *查询所有的用户角色
     * @return
     */
    public List<as_user> GetUserroleAlldao();

    public List<as_role> GetRolesAlldao();

    /**
     * 根据条件查询
     * @return
     */
    public List<as_user> GetUserconditionAlldao( @Param("before") int before, @Param("after") int after)throws Exception;
    public int counts()throws Exception;
    /**
     * 根据条件查询
     * @param userName
     * @param roleId
     * @param isStart
     * @return
     */
    public List<as_user> GetUserconditionAllingdao(@Param("userName")String userName,@Param("roleId")Integer roleId,@Param("isStart") int isStart,@Param("before") int before,@Param("after") int after);
    public int counting(@Param("userName")String userName,@Param("roleId")int roleId,@Param("isStart") int isStart);

    /**
     * 提交代理商
     * @param as_user
     * @return
     */
    public int addUserdao(as_user as_user);

    /**
     * 根据条件删除
     * @param id
     * @return
     */
    public int delUserdao(@Param("id")int id);

    /**
     * 修改
     * @param as_user
     * @return
     */
    public int updUserdao(as_user as_user);

    /**
     * 查询旧密码是否正确
     * @param id
     * @param pwd
     * @return
     */
    public int GetoldDao(@Param("id")int id,@Param("pwd")String pwd);

    /**
     * 修改密码
     * @param id
     * @param pwd
     * @return
     */
    public int updPwdDao(@Param("id")int id,@Param("pwd")String pwd);
}
