package com.acom.entities.mapper;

import com.acom.entities.model.Privilege;
import com.acom.entities.model.PrivilegeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    long countByExample(PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int deleteByExample(PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int insert(Privilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int insertSelective(Privilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    List<Privilege> selectByExample(PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    Privilege selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int updateByExampleSelective(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int updateByExample(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int updateByPrimaryKeySelective(Privilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table privilege
     *
     * @mbg.generated Tue Jun 06 17:48:09 CST 2017
     */
    int updateByPrimaryKey(Privilege record);
}