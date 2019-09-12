package com.jxnu.demo.service;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.dao.MassInfoMapper;

import java.util.List;

public interface MassService {

    List<MassInfo> selectMass() throws Exception;



}
