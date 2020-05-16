package com.jxnu.demo.service;

import com.jxnu.demo.bean.MassUser;
import com.jxnu.demo.bean.MassUserExample;

import java.util.List;

public interface MassUserService {

    List<Integer> selectMassUser(Integer id) throws Exception;

    int add(String userId,Integer state);

    int massDelUser(Integer massId);

    int add(Integer massId,String userId,Integer state);
    List<MassUser> selectByExample(MassUserExample example);
}
