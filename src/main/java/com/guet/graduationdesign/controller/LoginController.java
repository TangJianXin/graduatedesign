package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    登录控制器
* @Author:         TJX
* @CreateDate:     2019-04-26 11:53
* @UpdateUser:
* @UpdateDate:     2019-04-26 11:53
* @UpdateRemark:
* @Version:        1.0
*/
@RequestMapping(value = "/login")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
}
