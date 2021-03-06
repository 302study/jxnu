package com.jxnu.demo.service;

import com.jxnu.demo.bean.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> selectActivity();

    List<Activity> selectActivityWx();

    List<Activity> selectActivityByMassIdWx(Integer massId);

    int insertSelective(Activity activity);

    int deleteById(Integer id);

    List<Activity> selectByName(String name);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity activity);

    int peopleAddOne(Integer id);

    List<Activity> selectByUserId(String userId);


}
