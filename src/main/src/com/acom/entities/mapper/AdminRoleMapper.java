package com.acom.entities.mapper;

import com.acom.entities.model.AdminRole;
import com.acom.entities.model.AdminRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    long countByExample(AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int deleteByExample(AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int insert(AdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int insertSelective(AdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    List<AdminRole> selectByExample(AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    AdminRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int updateByExampleSelective(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int updateByExample(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int updateByPrimaryKeySelective(AdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Tue Jun 06 17:46:28 CST 2017
     */
    int updateByPrimaryKey(AdminRole record);
}