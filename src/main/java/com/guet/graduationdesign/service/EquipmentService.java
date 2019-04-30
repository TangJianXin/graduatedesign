package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Equipment;

import java.util.List;


public interface EquipmentService {

    //根据Id查询设备
    public Equipment findById(String equipmentId);

    //查询所有设备
    public List<Equipment> findAll();

    //根据Id删除设备
    public void deleteById(String equipmentId);

    //更新设备
    public Equipment update(String equipmentId, String equipmentName,
                            String purchaseDate,String productionDate,String departmentId);

    //添加设备
    public Equipment add(String equipmentId, String equipmentName,
                         String purchaseDate,String productionDate,String departmentId);
}
