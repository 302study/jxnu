package com.jxnu.demo.service.Impl;

import com.jxnu.demo.bean.MassInfo;
import com.jxnu.demo.bean.UserInfo;
import com.jxnu.demo.dao.MassInfoMapper;
import com.jxnu.demo.service.MassService;
import org.checkerframework.checker.units.qual.Mass;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class MassServiceImpl implements MassService {
    @Autowired
    private MassInfoMapper bac;

    @Override
    public List<MassInfo> selectMass(){
        List<MassInfo> list=bac.SelectMass();
        for(MassInfo i:list){
            i.createPhotoArray();
        }
        return list;
    }

    /**
     * 将massinfo添加进社团表中
     * @param massinfo
     * @return
     */
    @Override
    public int add(MassInfo massinfo){
        return bac.insertSelective(massinfo);
    }



    @Override
    public int del(MassInfo massinfo){
        return bac.deleteByPrimaryKey(massinfo.getId());
    }

    @Override
    public int update(MassInfo massinfo){
        return bac.updateByPrimaryKeySelective(massinfo);
    }

    @Override
    public MassInfo selectByPrimaryKey(Integer id){
        MassInfo massInfo=bac.selectByPrimaryKey(id);
        massInfo.createPhotoArray();
        return massInfo;
    }

    @Override
    public int updateMassLeader(Integer id,String user_id) {
        return bac.updateMassLeader(id,user_id);
    }

    @Override
    public List<UserInfo> selectMassUser(Integer id) {
        return bac.selectMassUser(id);
    }

    @Override
    public List<MassInfo> selectByName(String name) {
        name="%"+name+"%";
        List<MassInfo> list=bac.selectByName(name);
        for(MassInfo i:list){
            i.createPhotoArray();
        }
        return list;
    }

    @Override
    public int joinMass(Integer id) {
        return bac.joinMass(id);
    }

    @Override
    public List<MassInfo> selectByUserId(String userId) {
        List<MassInfo> list=bac.selectByUserId(userId);
        for(MassInfo i:list){
            i.createPhotoArray();
        }
        return list;
    }


}
