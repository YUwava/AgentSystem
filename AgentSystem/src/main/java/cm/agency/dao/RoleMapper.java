package cm.agency.dao;

import cm.agency.entity.as_role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有的角色或根据条件查询
     * @return
     */
    public List<as_role> GetRoleAlldao(@Param("before") int before,@Param("after") int after);

    /**
     * 添加角色
     * @param as_role
     * @return
     */
    public int addRoledao(as_role as_role);

    /**
     * 修改角色
     * @param as_role
     * @return
     */
    public int updRoledao(as_role as_role);

    /**
     * 删除指定角色
     * @param id
     * @return
     */
    public int delRoledao(@Param("id")int id);

    public int count();

}
