package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Department;

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
}
