package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.Topic;
import com.jxnu.demo.dao.TopicMapper;
import com.jxnu.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper bac;

    @Override
    public List<Topic> selectTopic() {
        return bac.selectTopic();
    }

    @Override
    public int deleteById(Integer id) {
        Topic topic=new Topic();
        topic.setId(id);
        topic.setState(1);
        return bac.updateByPrimaryKeySelective(topic);
    }

    @Override
    public int insert(Topic topic) {
        return 0;
    }
}