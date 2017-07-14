package com.acom.services.impl;

import com.acom.entities.mapper.AdminModuleMapper;
import com.acom.entities.mapper.AdminRoleMapper;
import com.acom.entities.mapper.AdminUserMapper;
import com.acom.entities.mapper.PrivilegeMapper;
import com.acom.entities.model.*;
import com.acom.services.sv.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户SV
 *
 * @author zhaojy
 * @createTime 2017-06-05
 */
@Service(value = "adminUserService")
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Autowired
    private AdminModuleMapper adminModuleMapper;

    @Override
    public AdminUser getAdminUserById(int userId) {
        return this.adminUserMapper.selectByPrimaryKey(1);
    }

    @Override
    public AdminUser getAdminUserByNameAndPwd(String userName, String passWd) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andLoginAcctEqualTo(userName).andPasswdEqualTo(passWd);
        List<AdminUser> adminUserList = adminUserMapper.selectByExample(example);
        if (null != adminUserList && adminUserList.size() == 1) {
            return adminUserList.get(0);
        }
        return null;
    }

    @Override
    public boolean addAdminUser(AdminUser adminUser) {
        int insert = this.adminUserMapper.insertSelective(adminUser);
        return insert > 0;
    }

    @Override
    public List<Privilege> getAllPrivileges() {
        PrivilegeExample example = new PrivilegeExample();
        PrivilegeExample.Criteria criteria = example.createCriteria();
        return privilegeMapper.selectByExample(example);
    }

    @Override
    public List<AdminRole> getRoleList() {
        AdminRoleExample example = new AdminRoleExample();
        example.createCriteria().andIdGreaterThan(0);
        return adminRoleMapper.selectByExample(example);
    }

    @Override
    public boolean saveAdminModule(AdminModule adminModule) {
        return adminModuleMapper.insert(adminModule) > 0;
    }
}
