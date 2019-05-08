package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface EquipmentService {

    //根据Id查询设备
    public Result findById(Integer equipmentId);

    //查询所有设备
    public Result findAll();

    //根据Id删除设备
    public Result deleteById(Integer equipmentId);

    //更新设备
    public Result update(Integer equipmentId, String equipmentName,
                            String purchaseDate,String productionDate,String departmentId);

    //添加设备
    public Result add(Integer equipmentId, String equipmentName,
                         String purchaseDate,String productionDate,String departmentId);
}
