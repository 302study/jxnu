package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassUser;
import com.jxnu.demo.bean.MassUserExample;
import com.jxnu.demo.dao.MassUserMapper;
import com.jxnu.demo.service.MassUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MassUserServiceImpl implements MassUserService {

    @Autowired
    private MassUserMapper bac;

    @Override
    public List<Integer> selectMassUser(Integer id) throws Exception{
        List<Integer> rec=bac.selectUserIdByMassId(id);
        if(rec.size()==0)
            return null;
        else return rec;
    }

    /**
     * 添加新的社团用户关联数据(社团id为最新插入的社团id，无需填写)
     * @param userId
     * @param state
     * @return
     */
    @Override
    public int add(String userId, Integer state) {
        MassUser massUser=new MassUser();
        massUser.setId(null);
        massUser.setUserId(userId);
        massUser.setState(state);
        return bac.insertSelective2(massUser);
    }

    /**
     * 将该massId的所有数据删除状态设置为1（已删除）
     * @param massId
     * @return
     */
    @Override
    public int massDelUser(Integer massId) {
        if(massId == 0)
            return 0;
        return bac.massDelUser(massId);
    }

    @Override
    public int add(Integer massId, String userId, Integer state) {
        MassUser massUser=new MassUser();
        massUser.setMassId(massId);
        massUser.setUserId(userId);
        massUser.setState(state);
        return bac.insertSelective(massUser);
    }

    @Override
    public List<MassUser> selectByExample(MassUserExample example) {
        return bac.selectByExample(example);
    }


}
