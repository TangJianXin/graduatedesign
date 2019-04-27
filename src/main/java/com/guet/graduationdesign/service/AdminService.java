package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Admin;

import java.util.List;

public interface AdminService {

    //查询所有管理员账号信息
    public List<Admin> findAll();

    //通过用户名查询管理员账号信息
    public Admin findByUsername(String username);

    //根据用户名删除管理员账号
    public void deleteByUsername(String username);

    //修改密码
    public Admin update(String username,String password,Integer employerId);

    //注册
    public Admin add(String username,String password,Integer employerId);

    //根据员工Id查询管理员账号密码
    public Admin findByEmployerId(Integer employerId);
}
