package com.acom.services.impl;

import com.acom.entities.mapper.AdminUserMapper;
import com.acom.entities.model.AdminUser;
import com.acom.services.sv.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaojy on 2017/6/5.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUserById(int userId) {
        return this.adminUserMapper.selectByPrimaryKey(1);
    }
}
