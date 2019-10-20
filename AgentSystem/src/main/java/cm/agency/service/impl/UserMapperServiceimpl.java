package cm.agency.service.impl;

import cm.agency.dao.UserMapper;
import cm.agency.entity.as_role;
import cm.agency.entity.as_user;
import cm.agency.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userMapperService")
public class UserMapperServiceimpl implements UserMapperService {
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<as_user> GetUserAccountAndPwdService(String userCode,String userpwd) {
        return userMapper.GetUserAccountAndPwddao(userCode,userpwd);
    }


    @Override
    public List<as_user> GetUserroleAllService() {
        return userMapper.GetUserroleAlldao();
    }

    @Override
    public List<as_role> GetRolesAllService() {
        return userMapper.GetRolesAlldao();
    }

    @Override
    public List<as_user> GetUserconditionAllService(int before, int after)throws Exception {
        return userMapper.GetUserconditionAlldao(before,after);
    }

    @Override
    public int counts()throws Exception {
        return userMapper.counts();
    }

    @Override
    public List<as_user> GetUserconditionAllingdao(String userName, Integer roleId, int isStart, int before, int after) {
        return userMapper.GetUserconditionAllingdao(userName,roleId,isStart,before,after);
    }

    @Override
    public int counting(String userName, int roleId, int isStart) {
        return userMapper.counting(userName,roleId,isStart);
    }

    @Override
    public int addUserdaoService(as_user as_user) {
        return userMapper.addUserdao(as_user);
    }

    @Override
    public int delUserService(int id) {
        return userMapper.delUserdao(id);
    }

    @Override
    public int updUserService(as_user as_user) {
        return userMapper.updUserdao(as_user);
    }

    @Override
    public int GetoldService(int id, String pwd) {
        return userMapper.GetoldDao(id,pwd);
    }

    @Override
    public int updPwdService(int id, String pwd) {
        return userMapper.updPwdDao(id,pwd);
    }
}
