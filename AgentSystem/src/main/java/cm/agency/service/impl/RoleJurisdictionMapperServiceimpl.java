package cm.agency.service.impl;

import cm.agency.dao.RoleJurisdictionMapper;
import cm.agency.entity.as_role;
import cm.agency.entity.as_role_premission;
import cm.agency.entity.as_user;
import cm.agency.service.RoleJurisdictionMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RoleJurisdictionMapperService")
public class RoleJurisdictionMapperServiceimpl implements RoleJurisdictionMapperService {
    @Autowired
    private RoleJurisdictionMapper roleJurisdictionMapper;
    public RoleJurisdictionMapper getRoleJurisdictionMapper() {
        return roleJurisdictionMapper;
    }

    public void setRoleJurisdictionMapper(RoleJurisdictionMapper roleJurisdictionMapper) {
        this.roleJurisdictionMapper = roleJurisdictionMapper;
    }


    @Override
    public List<as_role> GetRoleService() {
        return roleJurisdictionMapper.GetRoleDao();
    }

    @Override
    public int counts(int roleId) throws Exception {
        return roleJurisdictionMapper.counts(roleId);
    }

    @Override
    public List<as_role_premission> GetRoleJurisdictionAllingdao(int roleId, int before, int after) {
        return roleJurisdictionMapper.GetRoleJurisdictionAllingdao(roleId,before,after);
    }

    @Override
    public int updRoleJurisdictionidService(int id, int isStart) {
        return roleJurisdictionMapper.updRoleJurisdictioniddao(id,isStart);
    }
}
