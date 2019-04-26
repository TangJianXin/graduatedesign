package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(value = "/admin")
    public Admin loginByAdmin(@RequestParam("username") String username,
                              @RequestParam("password") String password)
    {
        /**
        * @Description: 管理员登录
        * @Author:      TJX
         * @param username
         * @param password
        * @Return      com.guet.graduationdesign.pojo.Admin
        * @Exception
        * @Date        2019-04-26 17:23
        */
        return loginService.loginByAdmin(username,password);
    }

    @PostMapping(value = "/user")
    public User loginByUser(@RequestParam("username") String username,
                            @RequestParam("password") String password)
    {
        /**
        * @Description: 普通员工登录
        * @Author:      TJX
         * @param username
         * @param password
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-26 17:25
        */
        return loginService.loginByUser(username,password);
    }
}
