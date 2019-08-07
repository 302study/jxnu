package com.jxnu.demo.dao;

import com.jxnu.demo.bean.SecondaryReply;
import com.jxnu.demo.bean.SecondaryReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondaryReplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    long countByExample(SecondaryReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int deleteByExample(SecondaryReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int insert(SecondaryReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int insertSelective(SecondaryReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    List<SecondaryReply> selectByExample(SecondaryReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    SecondaryReply selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SecondaryReply record, @Param("example") SecondaryReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SecondaryReply record, @Param("example") SecondaryReplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SecondaryReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table secondary_reply
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SecondaryReply record);
}