package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface BedService {
    //根据Id查询床位
    public Result findById(String bedId);

    //查询所有床位
    public Result findAll();

    //根据Id删除床位
    public Result deleteById(String bedId);

    //更新床位
    public Result update(String bedId,Integer oldPeopleId,Integer employerId);

    //添加床位
    public Result add(String bedId,Integer employerId);

    //设置床位的管理人员
    public Result setAdminEmployer(String bedId,Integer employerId);

    //设置床位的使用老人
    public Result setUserOldPeople(String bedId,Integer oldPeopleId);

}
