package com.jxnu.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jxnu.demo.bean.Contentuser;
import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.bean.UserInfo;
import com.jxnu.demo.commoon.ReturnCode;
import com.jxnu.demo.commoon.ServerResponse;
import com.jxnu.demo.service.ContentUseService;
import com.jxnu.demo.service.MassService;
import com.jxnu.demo.service.MassUserService;
import com.jxnu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/MassController")
@CrossOrigin(allowCredentials = "true")
public class MassController {
    @Autowired
    MassService massService;
    @Autowired
    ContentUseService contentUseService;
    @Autowired
    MassUserService massUserService;
    @Autowired
    UserService userService;

    @RequestMapping("/selectMass")
    @ResponseBody
    public ServerResponse selectMass() throws Exception {
        List<MassInfo> list=massService.selectMass();
        if(list == null){
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }else{
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),list);
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id) throws Exception {
        MassInfo massInfo=massService.selectByPrimaryKey(id);
        if(massInfo == null){
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }else{
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),massInfo);
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public ServerResponse login(Contentuser contentuser) throws Exception {
        if(contentUseService.login(contentuser.getAdministrator(),contentuser.getPassword()))
            return ServerResponse.CreateServerResponse(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg());
        return ServerResponse.CreateServerResponse(ReturnCode.ERROR.getCode(),ReturnCode.ERROR.getMsg());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insertMass(MassInfo massInfo) throws Exception {

        try {
            massService.add(massInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(),ReturnCode.INSERT_ERROR.getMsg());
        }

        return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
    }

    @RequestMapping("/update")
    @ResponseBody
    public ServerResponse updateMass(MassInfo massInfo) throws Exception {

        try {
            massService.update(massInfo);
            massService.updateMassLeader(massInfo.getId(),massInfo.getLeader_userId());
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }

    /**
     * 删除，
     * @param massInfo id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteMass(MassInfo massInfo) throws Exception {

        try {
            massInfo.setState(1);
            massService.update(massInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.DELETE_ERROR.getCode(),ReturnCode.DELETE_ERROR.getMsg());
        }
        return ServerResponse.CreateServerResponse(ReturnCode.DELETE_SUCCESS.getCode(),ReturnCode.DELETE_SUCCESS.getMsg());
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public ServerResponse selectUser(int mass_id) throws  Exception {
        List<UserInfo> list_user;

        try {
            List<Integer> user_id=massUserService.selectMassUser(mass_id);
            list_user=userService.selectByListId(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg());
        }
        return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),list_user);
    }

}
