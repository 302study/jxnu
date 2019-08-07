package com.jxnu.demo;

import com.jxnu.demo.bean.student;
import com.jxnu.demo.service.stuservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
   @Autowired
   private stuservice sdsaty;
    @RequestMapping("/hello")
    public String saaay(){
        student st=sdsaty.findstu();
        return st.getTest();
    }
}
