package com.jxnu.demo.controller;

import com.jxnu.demo.bean.Topic;
import com.jxnu.demo.commoon.ReturnCode;
import com.jxnu.demo.commoon.ServerResponse;
import com.jxnu.demo.service.TopicService;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/TopicController")
@CrossOrigin(allowCredentials = "true")
public class TopicController {
    @Autowired
    TopicService topicService;

    /**
     * 查询所有话题，按照优先级排序
     * @return
     */
    @RequestMapping("/selectTopic")
    @ResponseBody
    public ServerResponse selectTopic()  {
        try{
            List<Topic> list=topicService.selectTopic();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),list);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }
    }

    /**
     * wx查询所有话题，按照like_number排序（查询最热门话题）
     * @return
     */
    @RequestMapping("/selectHotTopic")
    @ResponseBody
    public ServerResponse selectHotTopicWx()  {
        try{
            List<Topic> list = topicService.selectHotTopicWx();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),list);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }
    }

    /**
     * 查询所以有话题，按照date排序（查询最新话题）
     */
    @RequestMapping("/selectRecentTopic")
    @ResponseBody
    public ServerResponse selectRecentTopicWx()  {
        try{
            List<Topic> list=topicService.selectRecentTopicWx();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),list);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }
    }

    /**
     * 根据话题id查询话题
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public ServerResponse selectById(int id)  {
        Topic topic=topicService.selectById(id);
        if(topic == null){
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_ERROR.getCode(),null);
        }else{
            return ServerResponse.CreateServerResponse(ReturnCode.SELECT_SUCCESS.getCode(),topic);
        }
    }

    /**
     * 根据话题id，更新话题（空字段不更新）
     * @param topic
     * @return
     */
    @RequestMapping("/updateTopic")
    @ResponseBody
    public ServerResponse updateTopic(Topic topic) {
        try {
            topicService.updateSelective(topic);
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }

    /**
     * 根据话题id，删除话题
     * @param topic
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public ServerResponse deleteById(Topic topic) {
        try {
            topic.setState(1);
            topicService.updateSelective(topic);
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_SUCCESS.getCode(),ReturnCode.UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.UPDATE_ERROR.getCode(),ReturnCode.UPDATE_ERROR.getMsg());
        }
    }

    /**
     * 新增话题
     * @param topic
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public ServerResponse insert(Topic topic) {
        try {
            topicService.insertSelective(topic);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.CreateServerResponse(ReturnCode.INSERT_ERROR.getCode(),ReturnCode.INSERT_ERROR.getMsg());
        }
        return ServerResponse.CreateServerResponse(ReturnCode.INSERT_SUCCESS.getCode(),ReturnCode.INSERT_SUCCESS.getMsg());
    }


}
