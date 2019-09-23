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

    @Override
    public List<UserInfo> selectByListId(List<Integer> listId) {
        return bac.selectByListId(listId);
    }
}
