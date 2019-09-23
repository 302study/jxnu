package com.jxnu.demo.service;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.dao.MassInfoMapper;

import java.util.List;

public interface MassService {

    List<MassInfo> selectMass() throws Exception;

    int add(MassInfo massinfo) throws Exception;

    int del(MassInfo massinfo) throws Exception;

    int update(MassInfo massinfo) throws  Exception;
    MassInfo selectByPrimaryKey(Integer id);

}
