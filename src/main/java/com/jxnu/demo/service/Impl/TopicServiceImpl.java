package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.Reply;
import com.jxnu.demo.bean.Topic;
import com.jxnu.demo.dao.ReplyMapper;
import com.jxnu.demo.dao.TopicMapper;
import com.jxnu.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper bac;
    @Autowired
    ReplyMapper replybac;

    @Override
    public List<Topic> selectTopic() {
        return bac.selectTopic();
    }

    @Override
    public List<Topic> selectHotTopicWx() {
        return bac.selectHotTopicWx();
    }

    @Override
    public List<Topic> selectRecentTopicWx() {
        return bac.selectRecentTopicWx();
    }

    @Override
    public Topic selectById(Integer id) {
        return bac.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Integer id) {
        Topic topic=new Topic();
        topic.setId(id);
        topic.setState(1);
        return bac.updateByPrimaryKeySelective(topic);
    }

    @Override
    public int insertSelective(Topic topic) {
        return bac.insertSelective(topic);
    }

    @Override
    public int updateSelective(Topic topic) {
        return bac.updateByPrimaryKeySelective(topic);
    }

    @Override
    public List<Topic> selectByName(String name) {
        name="%"+name+"%";
        List<Topic> list=bac.selectByName(name);

        return list;
    }

    @Override
    public int replyTopic(Reply reply){
        return replybac.insertSelective(reply);
    }

    @Override
    public List<Reply> SeletReplyByTopId(Reply reply){
        return replybac.SeletReplyByTopId(reply.getTopicId());
    }

}
