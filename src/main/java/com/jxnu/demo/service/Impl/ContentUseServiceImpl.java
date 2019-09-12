package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.Contentuser;
import com.jxnu.demo.dao.ContentuserMapper;
import com.jxnu.demo.service.ContentUseService;
import com.jxnu.demo.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ContentUseServiceImpl implements ContentUseService {

    @Autowired
    private ContentuserMapper con;

    @Value("${MD5.key}")
    private String key;

    @Override
    public Boolean login(String Administrator,String password) throws Exception {
        Contentuser contentuser=con.login(Administrator);
        if(contentuser==null)return false;
        MD5 md=new MD5();
        if(md.verify(password,key,contentuser.getPassword()))return true;
        return false;
    }

}
