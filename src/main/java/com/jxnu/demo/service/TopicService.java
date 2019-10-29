package com.jxnu.demo.service;

import com.jxnu.demo.bean.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> selectTopic();

    int deleteById(Integer id);

    int insert(Topic topic);

}
