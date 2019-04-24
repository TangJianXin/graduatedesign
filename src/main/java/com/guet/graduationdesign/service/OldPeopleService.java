package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.OldPeople;

import java.util.ArrayList;

public interface OldPeopleService {

    //根据Id查询老人
    public OldPeople findById(Integer oldPeopleId);

    //查询所有老人
    public ArrayList<OldPeople> findAll();

    //根据Id删除老人
    public void delete(Integer oldPeopleId);

    //更新老人
    public OldPeople update(OldPeople oldPeople);

    //添加老人
    public OldPeople add(OldPeople oldPeople);

}
