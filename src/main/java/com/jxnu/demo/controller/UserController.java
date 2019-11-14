package com.jxnu.demo.controller;

import com.jxnu.demo.bean.Activity;
import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.bean.UserInfo;
import com.jxnu.demo.commoon.ReturnCode;
import com.jxnu.demo.commoon.ServerResponse;
import com.jxnu.demo.service.ActivityService;
import com.jxnu.demo.service.MassService;
import com.jxnu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/UserController")
@CrossOrigin(allowCredentials = "true")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ActivityService activityService;
    @Autowired
    MassService massService;

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public ServerResponse selectById(String id){
        try{
            UserInfo userInfo=userService.selectById(id);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     * 查询所有的用户
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public ServerResponse selectAll(){
        try{
            List<UserInfo> userList=userService.selectUser();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),userList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     * 根据用户id更新用户信息，为空字段不更新
     * @param userInfo
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public ServerResponse updateUser(UserInfo userInfo) {
        try {
            //更新其它关联表

            //更新个人表
            userService.updateSelective(userInfo);
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }

    /**
     * 插入新用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(UserInfo userInfo) {
        try {
            userService.insertSelective(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(),ReturnCode.INSERT_ERROR.getMsg());
        }
        return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
    }

    /**
     * 用户登入
     * 若该用户为新用户，则将新用户存入数据库
     * 若薇老用户，则修改name为最新名字
     */
    @RequestMapping("/wxLogin")
    @ResponseBody
    public ServerResponse wxLogin(UserInfo userInfo) {
        try {
            userService.merge(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(),ReturnCode.INSERT_ERROR.getMsg());
        }
        return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
    }

    /**
     * 通过用户Id，查找该用户参与的活动
     * @param userInfo
     * @return
     */
    @RequestMapping("/selectActById")
    @ResponseBody
    public ServerResponse selectActById(UserInfo userInfo) {
        try {
            List<Activity> activityList=activityService.selectByUserId(userInfo.getId());
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),activityList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     * 通过用户Id，查找该用户参与的社团
     */
    @RequestMapping("/selectMassById")
    @ResponseBody
    public ServerResponse selectMassById(UserInfo userInfo) {
        try {
            List<MassInfo> massList=massService.selectByUserId(userInfo.getId());
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),massList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

}
