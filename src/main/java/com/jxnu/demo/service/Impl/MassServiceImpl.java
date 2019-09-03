package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.dao.MassInfoMapper;
import com.jxnu.demo.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MassServiceImpl implements MassService {

    @Autowired
    private MassInfoMapper MassDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public List<MassInfo> selectMass() {
        List<MassInfo> list=MassDao.SelectMass();
        redisTemplate.opsForValue().set("test1","反复");
        return list;
    }




}
