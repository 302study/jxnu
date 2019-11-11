package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.UserInfo;
import com.jxnu.demo.dao.UserInfoMapper;
import com.jxnu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper bac;

    /**
     * 通过Id集合查找用户集合
     * @param listId
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> selectByListId(List<String> listId) throws Exception{
        return bac.selectByListId(listId);
    }

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<UserInfo> selectUser() {
        return bac.selectUser();
    }

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @Override
    public UserInfo selectById(String id) {
        return bac.selectByPrimaryKey(id);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        return 0;
    }

    /**
     * 插入新的用户（仅非null的值）
     * @param userInfo
     * @return
     */
    @Override
    public int insertSelective(UserInfo userInfo) {
        return bac.insertSelective(userInfo);
    }

    /**
     * 根据用户id更新用户信息（仅更新参数非null值）
     * @param userInfo
     * @return
     */
    @Override
    public int updateSelective(UserInfo userInfo) {
        return bac.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int merge(UserInfo userInfo) {
        return bac.merge(userInfo);
    }


}
