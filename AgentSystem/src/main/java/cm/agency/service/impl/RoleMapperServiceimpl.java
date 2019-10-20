package cm.agency.service.impl;


import cm.agency.dao.RoleMapper;
import cm.agency.entity.as_role;
import cm.agency.service.RoleMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleMapperService")
public class RoleMapperServiceimpl implements RoleMapperService {
    @Autowired
    private RoleMapper roleMapper;
    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }


    @Override
    public List<as_role> GetRoleAlldao(int before, int after) {
        return roleMapper.GetRoleAlldao(before,after);
    }

    @Override
    public int count() {
        return roleMapper.count();
    }

    @Override
    public int addRoledao(as_role as_role) {
        return roleMapper.addRoledao(as_role);
    }

    @Override
    public int updRoledao(as_role as_role) {
        return roleMapper.updRoledao(as_role);
    }

    @Override
    public int delRoledao(int id) {
        return roleMapper.delRoledao(id);
    }
}

