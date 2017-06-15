package com.acom.services.impl;

import com.acom.entities.mapper.AdminUserMapper;
import com.acom.entities.mapper.PrivilegeMapper;
import com.acom.entities.model.AdminUser;
import com.acom.entities.model.AdminUserExample;
import com.acom.entities.model.Privilege;
import com.acom.entities.model.PrivilegeExample;
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

    public AdminUser getAdminUserById(int userId) {
        return this.adminUserMapper.selectByPrimaryKey(1);
    }

    public AdminUser getAdminUserByNameAndPwd(String userName, String passWd) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andLoginAcctEqualTo(userName).andPasswdEqualTo(passWd);
        List<AdminUser> adminUserList = adminUserMapper.selectByExample(example);
        if (null != adminUserList && adminUserList.size() == 1) {
            return adminUserList.get(0);
        }
        return null;
    }

    public boolean addAdminUser(AdminUser adminUser) {
        int insert = this.adminUserMapper.insertSelective(adminUser);
        return insert > 0;
    }

    public List<Privilege> getAllPrivileges() {
        PrivilegeExample example = new PrivilegeExample();
        PrivilegeExample.Criteria criteria = example.createCriteria();
        return privilegeMapper.selectByExample(example);
    }
}
