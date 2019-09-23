package com.jxnu.demo.service;

import com.jxnu.demo.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> selectByListId(List<Integer> listId);
}
