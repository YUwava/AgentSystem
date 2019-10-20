package cm.agency.service;

import cm.agency.entity.Page;
import cm.agency.entity.as_role;

import java.util.List;

public interface RoleMapperService {
    /**
     * 查询所有的角色或根据条件查询
     * @return
     */
    public List<as_role> GetRoleAlldao(int before,int after);

    public int count();

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
    public int delRoledao(int id);

}

