package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.OldPeople;
import java.util.List;


public interface OldPeopleService {

    //根据Id查询老人
    public OldPeople findById(Integer oldPeopleId);

    //查询所有老人
    public List<OldPeople> findAll();

    //根据Id删除老人
    public void delete(Integer oldPeopleId);

    //更新老人
    public OldPeople update(Integer oldPeopleId, String idCard, String photo,
                            String name, String telephone, String address,
                            String sex, String birthday,String familyPhone);

    //添加老人
    public OldPeople add(String idCard, String photo,
                         String name, String telephone, String address,
                         String sex, String birthday,String familyPhone,
                         String entryDate);


}
