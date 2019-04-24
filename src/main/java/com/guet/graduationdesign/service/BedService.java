package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Bed;
import java.util.List;

public interface BedService {
    //根据Id查询床位
    public Bed findById(String bedId);

    //查询所有床位
    public List<Bed> findAll();

    //根据Id删除床位
    public void deleteById(String bedId);

    //更新床位
    public Bed update(String bedId,Integer oldPeopleId,Integer employerId);

    //添加床位
    public Bed add(String bedId,Integer oldPeopleId,Integer employerId);
}
