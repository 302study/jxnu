package com.jxnu.demo.service;

import java.util.List;

public interface MassUserService {

    List<Integer> selectMassUser(Integer id) throws Exception;

    int add(Integer massId,Integer UserId,Integer state);

    int massDelUser(Integer massId);

}
