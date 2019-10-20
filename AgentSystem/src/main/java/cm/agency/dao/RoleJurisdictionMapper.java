package cm.agency.dao;

import cm.agency.entity.as_role;
import cm.agency.entity.as_role_premission;
import cm.agency.entity.as_user;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface RoleJurisdictionMapper {
    /**
     * 查询所有的角色
     * @return
     */
    public List<as_role> GetRoleDao();

    /**
     * 总条数
     * @return
     * @throws Exception
     */
    public int counts(@Param("roleId")int roleId)throws Exception;
    /**
     * 根据条件查询
     * @param
     * @param roleId
     * @param
     * @return
     */
    public List<as_role_premission> GetRoleJurisdictionAllingdao(@Param("roleId")int roleId, @Param("before") int before, @Param("after") int after);

    public int updRoleJurisdictioniddao(@Param("id")int id,@Param("isStart")int isStart);
}
