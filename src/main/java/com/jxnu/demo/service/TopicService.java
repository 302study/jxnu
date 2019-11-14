package com.jxnu.demo.service;

import com.jxnu.demo.bean.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> selectTopic();

    List<Topic> selectHotTopicWx();

    List<Topic> selectRecentTopicWx();

    Topic selectById(Integer id);

    int deleteById(Integer id);

    int insertSelective(Topic topic);

    int updateSelective(Topic topic);

}
