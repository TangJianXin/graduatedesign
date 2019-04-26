package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
* @Description:    普通员工账号管理控制器
* @Author:         TJX
* @CreateDate:     2019-04-26 09:33
* @UpdateUser:
* @UpdateDate:     2019-04-26 09:33
* @UpdateRemark:
* @Version:        1.0
*/
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> findAll()
    {
        /**
        * @Description: 查询所有普通员工账号信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.User>
        * @Exception
        * @Date        2019-04-26 09:34
        */
        return userService.findAll();
    }

    @PostMapping(value = "/findByUsername")
    public User findByUsername(@RequestParam("username") String username)
    {
        /**
        * @Description: 通过用户名查询普通员工账号信息
        * @Author:      TJX
         * @param user
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-26 09:36
        */
        return userService.findByUsername(username);
    }

    @DeleteMapping("/deleteByUsername")
    public String deleteByUsername(@RequestParam("username") String username)
    {
        /**
        * @Description: 根据用户名删除普通员工账号
        * @Author:      TJX
         * @param username
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-26 09:38
        */
        userService.deleteByUsername(username);
        return "删除成功";
    }

    @PostMapping("/modifyPassword")
    public User modifyPassword(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 修改普通员工账号密码
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-26 09:41
        */
        return userService.update(username,password,employerId);
    }

    @PostMapping("/register")
    public User register(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 注册普通员工账号
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-26 09:43
        */
        return userService.add(username,password,employerId);
    }
}
