package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface OldPeopleService {

    //根据Id查询老人
    public Result findById(Integer oldPeopleId);

    //查询所有老人
    public Result findAll();

    //根据Id删除老人
    public Result delete(Integer oldPeopleId);

    //更新老人
    public Result update(Integer oldPeopleId, String idCard, String photo,
                            String name, String telephone, String address,
                            String sex, String birthday,String familyPhone,String entryDate);

    //添加老人
    public Result add(String idCard, String photo,
                         String name, String telephone, String address,
                         String sex, String birthday,String familyPhone,
                         String entryDate);


}
