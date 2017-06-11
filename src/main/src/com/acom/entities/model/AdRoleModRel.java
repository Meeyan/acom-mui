package com.acom.entities.model;

import java.sql.Timestamp;

public class AdRoleModRel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_role_mod_rel.id
     *
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_role_mod_rel.role_id
     *
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_role_mod_rel.module_id
     *
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    private Integer moduleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_role_mod_rel.create_time
     *
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    private Timestamp createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_role_mod_rel.desc
     *
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    private String desc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_role_mod_rel.id
     *
     * @return the value of ad_role_mod_rel.id
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_role_mod_rel.id
     *
     * @param id the value for ad_role_mod_rel.id
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_role_mod_rel.role_id
     *
     * @return the value of ad_role_mod_rel.role_id
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_role_mod_rel.role_id
     *
     * @param roleId the value for ad_role_mod_rel.role_id
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_role_mod_rel.module_id
     *
     * @return the value of ad_role_mod_rel.module_id
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_role_mod_rel.module_id
     *
     * @param moduleId the value for ad_role_mod_rel.module_id
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_role_mod_rel.create_time
     *
     * @return the value of ad_role_mod_rel.create_time
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_role_mod_rel.create_time
     *
     * @param createTime the value for ad_role_mod_rel.create_time
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_role_mod_rel.desc
     *
     * @return the value of ad_role_mod_rel.desc
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_role_mod_rel.desc
     *
     * @param desc the value for ad_role_mod_rel.desc
     * @mbg.generated Tue Jun 06 17:44:20 CST 2017
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}