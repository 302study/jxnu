package com.jxnu.demo.service;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.dao.MassInfoMapper;

import java.util.List;

public interface MassService {

    List<MassInfo> selectMass();

    int add(MassInfo massinfo);

    int del(MassInfo massinfo);

    int update(MassInfo massinfo);

    MassInfo selectByPrimaryKey(Integer id);

    int updateMassLeader(Integer id,Integer user_id);
}
