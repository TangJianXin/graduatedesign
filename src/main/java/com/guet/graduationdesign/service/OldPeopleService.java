package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.OldPeople;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;


public interface OldPeopleService {

    //根据Id查询老人
    public OldPeople findById(Integer oldPeopleId);

    //查询所有老人
    public List<OldPeople> findAll();

    //根据Id删除老人
    public void delete(Integer oldPeopleId);

    //更新老人
    public OldPeople update(Integer oldPeopleId, String idCard, MultipartFile photo,
                            String name, String telephone, String address,
                            String sex, Date birthday,String familyPhone);

    //添加老人
    public OldPeople add(String idCard, MultipartFile photo,
                         String name, String telephone, String address,
                         String sex, Date birthday,String familyPhone);

}
