package com.jxnu.demo.service;

import com.jxnu.demo.bean.MassApply;

import java.util.List;
import java.util.Map;

public interface MassApplyService {
    int addApply(MassApply massApply);
    List<Map<String,String>> selectMassApply();
}
