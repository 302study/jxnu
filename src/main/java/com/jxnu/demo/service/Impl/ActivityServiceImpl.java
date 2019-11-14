package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.Activity;
import com.jxnu.demo.dao.ActivityMapper;
import com.jxnu.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper bac;

    /**
     * 按照优先级排序，查询所以的活动
     * @return
     */
    @Override
    public List<Activity> selectActivity(){
        return bac.selectAll();
    }

    /**
     * wx按照优先级排序，查询所以的活动
     * @return
     */
    @Override
    public List<Activity> selectActivityWx(){
        return bac.selectAllWx();
    }

    /**
     * wx查询某社团的活动接口
     * @return
     */
    @Override
    public List<Activity> selectActivityByMassIdWx(Integer massId){
        return bac.selectActivityByMassIdWx(massId);
    }

    /**
     * 添加新的活动(单个添加)
     * @param activity
     * @return
     */
    @Override
    public int insertSelective(Activity activity){
        return bac.insertSelective(activity);
    }

    @Override
    public int deleteById(Integer id) {
        Activity activity=new Activity();
        activity.setId(id);
        activity.setState(1);
        return bac.updateByPrimaryKeySelective(activity);
    }

    public List<Activity> selectByName(String name) {
        name="%"+name+"%";
        return bac.selectByName(name);
    }

    @Override
    public Activity selectByPrimaryKey(Integer id) {
        return bac.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Activity activity) {
        return bac.updateByPrimaryKeySelective(activity);
    }

    @Override
    public int peopleAddOne(Integer id) {
        Activity activity=new Activity();
        activity.setId(id);
        return bac.peopleAddOne(id);
    }

    @Override
    public List<Activity> selectByUserId(String userId) {
        return bac.selectByUserId(userId);
    }


}
