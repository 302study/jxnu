package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.dao.MassInfoMapper;
import com.jxnu.demo.service.MassService;
import com.jxnu.demo.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MassServiceImpl implements MassService {

    @Autowired
    private MassInfoMapper MassDao;

    @Value("${MD5.key}")
    private String age;

    @Override
    public List<MassInfo> selectMass() throws Exception {
        MD5 md=new MD5();
        List<MassInfo> list=MassDao.SelectMass();
        System.out.println(md.md5("123456",age));
        return list;
    }
}
