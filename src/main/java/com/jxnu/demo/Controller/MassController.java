package com.jxnu.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jxnu.demo.bean.Contentuser;
import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.service.ContentUseService;
import com.jxnu.demo.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/MassController")
public class MassController {
    @Autowired
    MassService massService;
    @Autowired
    ContentUseService contentUseService;

    @RequestMapping("/selectMass")
    @ResponseBody
    public String selectMass() throws Exception {
        List<MassInfo> list=massService.selectMass();
        ObjectMapper mapper=new ObjectMapper();
        String masslist=mapper.writeValueAsString(list);
        return masslist;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Contentuser contentuser) throws Exception {
        if(contentUseService.login(contentuser.getAdministrator(),contentuser.getPassword()))return "true";
        return "falseeeee";
    }


}
