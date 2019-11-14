package com.jxnu.demo.controller;

import com.jxnu.demo.bean.Activity;
import com.jxnu.demo.bean.ActivityUser;
import com.jxnu.demo.bean.UserInfo;
import com.jxnu.demo.commoon.ReturnCode;
import com.jxnu.demo.commoon.ServerResponse;
import com.jxnu.demo.service.ActivityService;
import com.jxnu.demo.service.ActivityUserService;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ActivityController")
@CrossOrigin(allowCredentials = "true")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @Autowired
    ActivityUserService activityUserService;

    /**
     *  查询活动页面的所有活动
     *  按优先级排序
     */
    @RequestMapping("/selectActivity")
    @ResponseBody
    public ServerResponse selectActivity(){

        try{
            List<Activity> activityList=activityService.selectActivity();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),activityList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     *  wx查询活动页面的所有活动
     *  按优先级排序
     */
    @RequestMapping("/selectActivityWx")
    @ResponseBody
    public ServerResponse selectActivityWx(){

        try{
            List<Activity> activityList=activityService.selectActivityWx();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),activityList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     *  wx查询某社团的活动接口
     *  按优先级排序
     */
    @RequestMapping("/selectActivityByMassIdWx")
    @ResponseBody
    public ServerResponse selectActivityByMassIdWx(Integer massId){

        try{
            List<Activity> activityList=activityService.selectActivityByMassIdWx(massId);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),activityList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     *  添加新的活动(单个添加)
     *  对象内元素可为空
     *  不用添加ActivityUser的数据
     */
    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Activity activity){

        try{
            //取日期前十位（2019-01-01）
            activity.cutDate();
            //插入新的活动
            activityService.insertSelective(activity);
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(), ReturnCode.INSERT_ERROR.getMsg());
        }
    }

    /**
     *  根据id号删除活动
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public ServerResponse deleteById(Integer id){
        try{
            activityService.deleteById(id);
            activityUserService.delByActivityId(id);
            return ServerResponse.CreateServerResponse(ReturnCode.DELETE_SUCCESS.getCode(),ReturnCode.DELETE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.DELETE_ERROR.getCode(),ReturnCode.DELETE_ERROR.getMsg());
        }
    }

    /**
     * 根据活动名称查找活动
     * @param name
     * @return
     */
    @RequestMapping("/selectByName")
    @ResponseBody
    public ServerResponse selectByName(@RequestParam(value = "name") String name){
        try{
            List<Activity> activityList=activityService.selectByName(name);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),activityList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public ServerResponse selectById(Integer id){
        try{
            Activity activity=activityService.selectByPrimaryKey(id);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),activity);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     * 更新活动
     * @param activity
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public  ServerResponse updateByPrimaryKeySelective(Activity activity){
        try{
            //取日期前十位（2019-01-01）
            activity.cutDate();
            //更新
            activityService.updateByPrimaryKeySelective(activity);
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }

    /**
     * 参加活动
     * 某个用户参加了该项活动
     * @param userId
     * @param activityId
     * @return
     */
    @RequestMapping("/joinActivity")
    @ResponseBody
    public ServerResponse joinActivity(String userId,Integer activityId){
        try{
            //活动表该活动参加人数+1
            activityService.peopleAddOne(activityId);
            //活动用户表，添加该用户与该活动的关联数据
            ActivityUser activityUser=new ActivityUser();
            activityUser.setActivityId(activityId);
            activityUser.setUserId(userId);
            activityUser.setDate(new Date(System.currentTimeMillis()));

            activityUserService.insertSelective(activityUser);

            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }



}
