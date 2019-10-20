package cm.agency.service;

import cm.agency.entity.as_role;
import cm.agency.entity.as_role_premission;
import cm.agency.entity.as_user;

import java.util.List;

public interface RoleJurisdictionMapperService {

    public List<as_role> GetRoleService();

    public int counts(int roleId)throws Exception;

    public List<as_role_premission> GetRoleJurisdictionAllingdao(int roleId, int before, int after);

    public int updRoleJurisdictionidService(int id,int isStart);

}
