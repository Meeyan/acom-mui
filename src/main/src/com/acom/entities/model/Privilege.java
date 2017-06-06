package com.acom.entities.model;

import java.sql.Timestamp;

public class Privilege {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column privilege.id
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column privilege.name
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column privilege.url
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column privilege.create_time
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    private Timestamp createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column privilege.desc
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    private String desc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column privilege.id
     *
     * @return the value of privilege.id
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column privilege.id
     *
     * @param id the value for privilege.id
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column privilege.name
     *
     * @return the value of privilege.name
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column privilege.name
     *
     * @param name the value for privilege.name
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column privilege.url
     *
     * @return the value of privilege.url
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column privilege.url
     *
     * @param url the value for privilege.url
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column privilege.create_time
     *
     * @return the value of privilege.create_time
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column privilege.create_time
     *
     * @param createTime the value for privilege.create_time
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column privilege.desc
     *
     * @return the value of privilege.desc
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column privilege.desc
     *
     * @param desc the value for privilege.desc
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}