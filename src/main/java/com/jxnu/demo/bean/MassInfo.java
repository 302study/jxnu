package com.jxnu.demo.bean;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table mass_info
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class MassInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.introduction
     *
     * @mbg.generated
     */
    private String introduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.number
     *
     * @mbg.generated
     */
    private Integer number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.leader
     *
     * @mbg.generated
     */
    private Integer leader_userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.leader
     *
     * @mbg.generated
     */
    private String leader;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.priority
     *
     * @mbg.generated
     */
    private Integer priority;

    /**
     * Database Column Remarks:
     *   1为删除，0为未删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mass_info.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mass_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.id
     *
     * @return the value of mass_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.id
     *
     * @param id the value for mass_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.name
     *
     * @return the value of mass_info.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.name
     *
     * @param name the value for mass_info.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.introduction
     *
     * @return the value of mass_info.introduction
     *
     * @mbg.generated
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.introduction
     *
     * @param introduction the value for mass_info.introduction
     *
     * @mbg.generated
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.number
     *
     * @return the value of mass_info.number
     *
     * @mbg.generated
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.number
     *
     * @param number the value for mass_info.number
     *
     * @mbg.generated
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.leader
     *
     * @return the value of mass_info.leader
     *
     * @mbg.generated
     */
    public String getLeader() {
        return leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.leader
     *
     * @param leader the value for mass_info.leader
     *
     * @mbg.generated
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.priority
     *
     * @return the value of mass_info.priority
     *
     * @mbg.generated
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.priority
     *
     * @param priority the value for mass_info.priority
     *
     * @mbg.generated
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mass_info.state
     *
     * @return the value of mass_info.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mass_info.state
     *
     * @param state the value for mass_info.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLeader_userId() {
        return leader_userId;
    }

    public void setLeader_userId(Integer leader_userId) {
        this.leader_userId = leader_userId;
    }
}