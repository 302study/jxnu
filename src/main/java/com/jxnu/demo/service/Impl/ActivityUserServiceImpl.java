package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.ActivityUser;
import com.jxnu.demo.dao.ActivityUserMapper;
import com.jxnu.demo.service.ActivityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityUserServiceImpl implements ActivityUserService {
    @Autowired
    ActivityUserMapper bac;

    @Override
    public int delByActivityId(Integer ActivityId) {
        return bac.delByActivityId(ActivityId);
    }

    @Override
    public int insertSelective(ActivityUser activityUser) {
        return bac.insertSelective(activityUser);
    }
}
