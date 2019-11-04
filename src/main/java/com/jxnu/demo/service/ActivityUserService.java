package com.jxnu.demo.service;

import com.jxnu.demo.bean.ActivityUser;

public interface ActivityUserService {

    int delByActivityId(Integer ActivityId);

    int insertSelective(ActivityUser activityUser);

}
