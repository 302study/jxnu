package com.jxnu.demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jxnu.demo.bean.MassInfo;
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

    @RequestMapping("/selectMass")
    @ResponseBody
    public String selectMass() throws JsonProcessingException {
        List<MassInfo> list=massService.selectMass();
        ObjectMapper mapper=new ObjectMapper();
        String masslist=mapper.writeValueAsString(list);
        return masslist;
    }



}
