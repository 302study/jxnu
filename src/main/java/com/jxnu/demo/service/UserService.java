package com.jxnu.demo.service;

import com.jxnu.demo.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> selectByListId(List<Integer> listId) throws Exception;

    List<UserInfo> selectUser();

    UserInfo selectById(Integer id);

    int deleteById(Integer id);

    int insertSelective(UserInfo userInfo);

    int updateSelective(UserInfo userInfo);
}
