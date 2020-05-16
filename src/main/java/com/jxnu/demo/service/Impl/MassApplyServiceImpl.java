package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassApply;
import com.jxnu.demo.dao.MassApplyMapper;
import com.jxnu.demo.service.MassApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MassApplyServiceImpl implements MassApplyService {

    @Autowired
    MassApplyMapper massApplyMapper;
    @Override
    public int addApply(MassApply massApply) {
        return massApplyMapper.insertSelective(massApply);
    }

    @Override
    public List<Map<String, String>> selectMassApply() {
        return massApplyMapper.selectMassApply();
    }

    @Override
    public int updateByPrimaryKey(MassApply record) {
        return massApplyMapper.updateByPrimaryKeySelective(record);
    }
}
