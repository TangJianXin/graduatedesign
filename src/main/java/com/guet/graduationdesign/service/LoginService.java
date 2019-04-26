package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.User;

public interface LoginService {

    //管理员登录
    public Admin loginByAdmin(String username,String password);

    //普通员工登录
    public User loginByUser(String username,String password);

}
