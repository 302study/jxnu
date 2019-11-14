package com.jxnu.demo.controller;

import com.jxnu.demo.bean.Contentuser;
import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.bean.UserInfo;
import com.jxnu.demo.commoon.ReturnCode;
import com.jxnu.demo.commoon.ServerResponse;
import com.jxnu.demo.service.ContentUseService;
import com.jxnu.demo.service.MassService;
import com.jxnu.demo.service.MassUserService;
import com.jxnu.demo.service.UserService;
import com.jxnu.demo.tool.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

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


    /**
     * 查找所有社团
     * @return
     */
    @RequestMapping("/selectMass")
    @ResponseBody
    public ServerResponse selectMass()  {
        List<MassInfo> list=massService.selectMass();
        if(list == null){
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }else{
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),list);
        }
    }

    /**
     * wx查找所有社团
     * @return
     */
    @RequestMapping("/selectMassWx")
    @ResponseBody
    public ServerResponse selectMassWx()  {
        List<MassInfo> list=massService.selectMass();
        if(list == null){
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }else{
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),list);
        }
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id)  {
        MassInfo massInfo=massService.selectByPrimaryKey(id);
        if(massInfo == null){
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }else{
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),massInfo);
        }
    }

    /**
     * 根据社团名称查找社团
     * @param name
     * @return
     */
    @RequestMapping("/selectByName")
    @ResponseBody
    public ServerResponse selectByName(String name){
        try{
            List<MassInfo> massList=massService.selectByName(name);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),massList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_ERROR.getMsg());
        }
    }

    /**
     * 查找社团所有成员
     * @param mass_id
     * @return
     */
    @RequestMapping("/selectMassUser")
    @ResponseBody
    public ServerResponse selectMassUser(Integer mass_id) {
        List<UserInfo> list_user;

        try {
            list_user=massService.selectMassUser(mass_id);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),list_user);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg());
        }
    }

    /**
     * wx查找社团所有成员
     * @param mass_id
     * @return
     */
    @RequestMapping("/selectMassUserWx")
    @ResponseBody
    public ServerResponse selectMassUserWx(Integer mass_id) {
        List<UserInfo> list_user;

        try {
            list_user=massService.selectMassUserWx(mass_id);
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),list_user);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg());
        }
    }

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping("/selectUser")
    @ResponseBody
    public ServerResponse selectUser(){
        List<UserInfo> list_user;
        try {
            list_user=userService.selectUser();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),list_user);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg());
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public ServerResponse login(Contentuser contentuser) throws Exception {
        if(contentUseService.login(contentuser.getAdministrator(),contentuser.getPassword()))
            return ServerResponse.CreateServerResponse(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg());
        return ServerResponse.CreateServerResponse(ReturnCode.ERROR.getCode(),ReturnCode.ERROR.getMsg());
    }

    /**
     * 新增社团
     * 新增社团与成员关联信息
     * @param massInfo
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insertMass(MassInfo massInfo) {

        try {
            String photo=massInfo.getPhoto();
            if(photo!=null) {
                photo = photo.replace("[", "");
                photo = photo.replace("]", "");
                photo = photo.replace("\"", "");
                massInfo.setPhoto(photo);
            }
            //将新社团添加进社团表
            massInfo.setState(2); //新增的社团状态默认为2，即未上架
            massService.add(massInfo);
            massUserService.add(massInfo.getLeaderUserid(),0);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(),ReturnCode.INSERT_ERROR.getMsg());
        }

        return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
    }

    /**
     * 图片上传
     * @param massInfo
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ServerResponse updateMass(MassInfo massInfo) {

        try {
            String photo=massInfo.getPhoto();
            if(photo!=null) {
                photo = photo.replace("[", "");
                photo = photo.replace("]", "");
                photo = photo.replace("\"", "");
                massInfo.setPhoto(photo);
            }
            massService.update(massInfo);
            massService.updateMassLeader(massInfo.getId(),massInfo.getLeaderUserid());
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }

    /**
     * 删除社团
     * 删除社团成员表中该社团的信息
     * 注：state=1
     * @param massInfo id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse deleteMass(MassInfo massInfo) {

        try {
            massInfo.setState(1);
            //设置社团表里该社团状态为删除
            massService.update(massInfo);
            //设置社团用户表里，该社团与用户关系状态为已删
            massUserService.massDelUser(massInfo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.DELETE_ERROR.getCode(),ReturnCode.DELETE_ERROR.getMsg());
        }
        return ServerResponse.CreateServerResponse(ReturnCode.DELETE_SUCCESS.getCode(),ReturnCode.DELETE_SUCCESS.getMsg());
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ServerResponse upload(MultipartFile file){
        try {
            String uuid=UUID.randomUUID().toString()+".jpg";
            String path="http://47.100.242.234/images/";
            boolean flag = new FtpUtil().uploadFile("/home/ftpuser/images",uuid,file.getInputStream());

            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),ReturnCode.SELECT_SUCCESS.getMsg(),path+uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),ReturnCode.SELECT_SUCCESS.getMsg());
        }
    }

    /**
     * 用户加入社团
     * @param userId
     * @param massId
     * @return
     */
    @RequestMapping("/joinMass")
    @ResponseBody
    public ServerResponse joinMass(String userId,int massId){
        try {
            //该社团人数+1
            MassInfo massInfo=new MassInfo();
            massInfo.setId(massId);
            massService.joinMass(massId);
            //社团用户表添加该用户信息
            massUserService.add(massId,userId,0);

            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
        }
    }

}
