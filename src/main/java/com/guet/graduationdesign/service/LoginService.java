package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface LoginService {

    //管理员登录
    public Result loginByAdmin(String username, String password);

    //普通员工登录
    public Result loginByUser(String username,String password);

    //登录
    public Result login(String username,String password);

}
