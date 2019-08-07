package com.jxnu.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String saaay() throws JsonProcessingException {
        student st=sdsaty.findstu();
        ObjectMapper mapper=new ObjectMapper();
        String student=mapper.writeValueAsString(st);
        return student;
    }
}
