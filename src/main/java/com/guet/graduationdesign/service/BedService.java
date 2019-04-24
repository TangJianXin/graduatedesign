package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Bed;

import java.util.ArrayList;

public interface BedService {
    //根据Id查询床位
    public Bed findById(String bedId);

    //查询所有床位
    public ArrayList<Bed> findAll();

    //根据Id删除床位
    public void deleteById(String bedId);

    //更新床位
    public Bed update(Bed bed);

    //添加床位
    public Bed add(Bed bed);
}
