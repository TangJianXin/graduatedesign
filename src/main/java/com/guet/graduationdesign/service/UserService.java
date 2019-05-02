package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface UserService {

    //查询所有普通员工账号信息
    public Result findAll();

    //根据用户名查询普通员工账号信息
    public Result findByUsername(String username);

    //根据用户名删除普通员工账号
    public Result deleteByUsername(String username);

    //修改密码
    public Result update(String username,String password,Integer employerId);

    //注册
    public Result add(String username,String password,Integer employerId);

    //根据员工Id查询普通员工账号密码
    public Result findByEmployerId(Integer employerId);
}
