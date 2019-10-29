package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassUser;
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
     * 添加新的社团用户关联数据
     * @param massId
     * @param userId
     * @param state
     * @return
     */
    @Override
    public int add(Integer massId, Integer userId, Integer state) {
        MassUser massUser=new MassUser();
        massUser.setId(null);
        massUser.setMassId(massId);
        massUser.setUserId(userId);
        massUser.setState(state);
        return bac.insertSelective(massUser);
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
}
