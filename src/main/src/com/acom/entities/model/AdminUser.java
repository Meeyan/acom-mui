package com.acom.entities.model;

import java.sql.Timestamp;

public class AdminUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.id
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.login_acct
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private String loginAcct;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.passwd
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private String passwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.role_id
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.real_name
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.phone
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.nick_name
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user.create_time
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    private Timestamp createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.id
     *
     * @return the value of admin_user.id
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.id
     *
     * @param id the value for admin_user.id
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.login_acct
     *
     * @return the value of admin_user.login_acct
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public String getLoginAcct() {
        return loginAcct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.login_acct
     *
     * @param loginAcct the value for admin_user.login_acct
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setLoginAcct(String loginAcct) {
        this.loginAcct = loginAcct == null ? null : loginAcct.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.passwd
     *
     * @return the value of admin_user.passwd
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.passwd
     *
     * @param passwd the value for admin_user.passwd
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.role_id
     *
     * @return the value of admin_user.role_id
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.role_id
     *
     * @param roleId the value for admin_user.role_id
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.real_name
     *
     * @return the value of admin_user.real_name
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.real_name
     *
     * @param realName the value for admin_user.real_name
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.phone
     *
     * @return the value of admin_user.phone
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.phone
     *
     * @param phone the value for admin_user.phone
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.nick_name
     *
     * @return the value of admin_user.nick_name
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.nick_name
     *
     * @param nickName the value for admin_user.nick_name
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user.create_time
     *
     * @return the value of admin_user.create_time
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user.create_time
     *
     * @param createTime the value for admin_user.create_time
     *
     * @mbg.generated Mon Jun 05 17:01:11 CST 2017
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}