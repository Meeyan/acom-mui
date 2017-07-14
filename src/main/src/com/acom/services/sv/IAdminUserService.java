package com.acom.services.sv;

import com.acom.entities.model.AdminModule;
import com.acom.entities.model.AdminRole;
import com.acom.entities.model.AdminUser;
import com.acom.entities.model.Privilege;

import java.util.List;

/**
 *
 */
public interface IAdminUserService {
    /**
     * 查询管理员
     *
     * @param userId 管理员id
     * @return
     * @author zhaojy
     * @createTime 2017-06-06
     */
    public AdminUser getAdminUserById(int userId);

    /**
     * 根据密码和用户名查询用户
     *
     * @param userName
     * @param passWd
     * @return Object
     */
    public AdminUser getAdminUserByNameAndPwd(String userName, String passWd);

    /**
     * 新增管理员账号
     *
     * @param adminUser 管理用户
     * @return boolean
     * @author zhaojy
     * @createTime 2017-06-06
     */
    public boolean addAdminUser(AdminUser adminUser);

    /**
     * 获取所有权限列表
     *
     * @return list
     * @author zhaojy
     * @createTime 2017-07-14
     */
    public List<Privilege> getAllPrivileges();

    /**
     * 获取所有的角色列表
     *
     * @return list
     * @author zhaojy
     * @createTime 2017-07-14
     */
    public List<AdminRole> getRoleList();

    /**
     *
     * @param adminModule
     * @return
     */
    public boolean saveAdminModule(AdminModule adminModule);


}
