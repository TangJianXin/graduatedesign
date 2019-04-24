package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Employer;

import java.util.ArrayList;

public interface EmployerService {

    //根据Id查询员工
    public Employer findById(String employerId);

    //查询所有员工
    public ArrayList<Employer> findAll();

    //根据Id删除员工
    public void deleteById(String employerId);

    //更新员工
    public Employer update(Employer employer);

    //添加员工
    public Employer add(Employer employer);
}
