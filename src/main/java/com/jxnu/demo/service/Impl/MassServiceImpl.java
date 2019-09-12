package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.dao.MassInfoMapper;
import com.jxnu.demo.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MassServiceImpl implements MassService {

    @Autowired
    private MassInfoMapper bac;



    @Override
    public List<MassInfo> selectMass() throws Exception {
        List<MassInfo> list=bac.SelectMass();
        return list;
    }




}
