package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassUser;
import com.jxnu.demo.dao.MassUserMapper;
import com.jxnu.demo.service.MassUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MassUserServiceImpl implements MassUserService {

    @Autowired
    private MassUserMapper bac;

    @Override
    public List<Integer> selectMassUser(int id) {
        return bac.selectUserIdByMassId(id);
    }
}
