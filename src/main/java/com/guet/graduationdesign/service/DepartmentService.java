package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;


public interface DepartmentService {

    //根据Id查询部门
    public Result findById(String departmentId);

    //查询所有部门
    public Result findAll();

    //根据Id删除部门
    public Result deleteById(String departmentId);

    //更新部门
    public Result update(String departmentId,String departmentName);

    //添加部门
    public Result add(String departmentId,String departmentName);

    //查询部门所有员工
    public Result findAllEmployer(String departmentId);

    //查询部门所有设备
    public Result findAllEquipment(String departmentId);

    //查询部门的人数和设备数量
    public Result findAllPeopleAndEquipment();
}
