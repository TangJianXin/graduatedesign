package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

import java.util.Date;

public interface QuotaService {

    //查询所有体征指标记录
    public Result findAll();

    //根据老人姓名查询体征指标记录
    public Result findByName(String name);

    //根据体征Id删除体征指标记录
    public Result deleteById(Integer quotaId);

    //添加一条体征指标记录
    public Result add(Integer heartRate, Integer breatheRate, Float temperature,
                      Integer oldPeopleId, String bedId);
}
