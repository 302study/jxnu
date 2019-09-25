package com.jxnu.demo.service;

import com.jxnu.demo.bean.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> selectActivity();

    int insertSelective(Activity activity);

    int deleteById(Integer id);

}
