package com.jxnu.demo.service;

import com.jxnu.demo.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> selectByListId(List<String> listId) throws Exception;

    List<UserInfo> selectUser();

    UserInfo selectById(String id);

    int deleteById(String id);

    int insertSelective(UserInfo userInfo);

    int updateSelective(UserInfo userInfo);

    int merge(UserInfo userInfo);
}
