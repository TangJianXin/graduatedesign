package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Department;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.Equipment;
import java.util.List;


public interface DepartmentService {

    //根据Id查询部门
    public Department findById(String departmentId);

    //查询所有部门
    public List<Department> findAll();

    //根据Id删除部门
    public void deleteById(String departmentId);

    //更新部门
    public Department update(String departmentId,String departmentName);

    //添加部门
    public Department add(String departmentId,String departmentName);

    //查询部门所有员工
    public List<Employer> findAllEmployer(String departmentId);

    //查询部门所有设备
    public List<Equipment> findAllEquipment(String departmentId);
}
