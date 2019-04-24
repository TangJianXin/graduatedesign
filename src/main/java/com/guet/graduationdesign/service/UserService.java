package com.guet.graduationdesign.service;


import com.guet.graduationdesign.pojo.User;

import java.util.List;

public interface UserService {

    //查询所有普通员工账号信息
    public List<User> findAll();

    //根据用户名查询普通员工账号信息
    public User findByUsername(String username);

    //根据用户名删除普通员工账号
    public void deleteByUsername(String username);

    //修改密码
    public User update(String username,String password,Integer employerId);

    //注册
    public User add(String username,String password,Integer employerId);
}
