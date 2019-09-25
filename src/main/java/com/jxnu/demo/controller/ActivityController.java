package com.jxnu.demo.controller;

import com.jxnu.demo.bean.Activity;
import com.jxnu.demo.commoon.ReturnCode;
import com.jxnu.demo.commoon.ServerResponse;
import com.jxnu.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ActivityController")
@CrossOrigin(allowCredentials = "true")
public class ActivityController {
    @Autowired
    ActivityService activityService;

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
     *  添加新的活动(单个添加)
     *  对象内元素可为空
     */
    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Activity activity){

        try{
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
            return ServerResponse.CreateServerResponse(ReturnCode.DELETE_SUCCESS.getCode(),ReturnCode.DELETE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.DELETE_ERROR.getCode(),ReturnCode.DELETE_ERROR.getMsg());
        }
    }

}
