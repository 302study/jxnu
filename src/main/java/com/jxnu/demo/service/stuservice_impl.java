package com.jxnu.demo.service;

import com.jxnu.demo.bean.student;
import com.jxnu.demo.dao.studao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class stuservice_impl implements stuservice{

    @Autowired
    private studao da;

    @Override
    public student findstu() {
        student st=da.findstu();
        System.out.println(st);
        return st;
    }
}
