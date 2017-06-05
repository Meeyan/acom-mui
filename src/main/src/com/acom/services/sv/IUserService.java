package com.acom.services.sv;

import com.acom.entities.model.AdminUser;

/**
 *
 */
public interface IUserService {
    public AdminUser getAdminUserById(int userId);

    public boolean addAdminUser(AdminUser adminUser);
}
