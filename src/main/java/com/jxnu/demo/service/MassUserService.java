package com.jxnu.demo.service;

import java.util.List;

public interface MassUserService {

    List<Integer> selectMassUser(Integer id) throws Exception;

    int add(String userId,Integer state);

    int massDelUser(Integer massId);

    int add(Integer massId,String userId,Integer state);
}
