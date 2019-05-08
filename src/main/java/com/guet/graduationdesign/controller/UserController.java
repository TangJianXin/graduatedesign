package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result findAll()
    {
        /**
        * @Description: 查询所有普通员工账号信息
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 09:34
        */
        return userService.findAll();
    }

    @GetMapping(value = "/findByUsername")
    public Result findByUsername(@RequestParam("username") String username)
    {
        /**
        * @Description: 通过用户名查询普通员工账号信息
        * @Author:      TJX
         * @param user
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 09:36
        */
        return userService.findByUsername(username);
    }

    @DeleteMapping("/deleteByUsername")
    public Result deleteByUsername(@RequestParam("username") String username)
    {
        /**
        * @Description: 根据用户名删除普通员工账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:59
        */
        return userService.deleteByUsername(username);
    }

    @PutMapping("/modifyPassword")
    public Result modifyPassword(@RequestParam("username") String username,
                               @RequestParam("password") String password)
    {
        /**
        * @Description: 修改普通员工账号密码
        * @Author:      TJX
         * @param username
         * @param password
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 09:41
        */
        return userService.update(username,password);
    }

    @PostMapping("/register")
    public Result register(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 注册普通员工账号
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 09:43
        */
        return userService.add(username,password,employerId);
    }

    @GetMapping(value = "/findByEmployerId")
    public Result findUserByEmployerId(@RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 根据员工Id查询普通员工账号密码
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-27 17:23
        */
        return userService.findByEmployerId(employerId);
    }

    @PostMapping(value = "/uploadImage")
    public Result uploadImage(String username,String image)
    {
        /**
        * @Description: 普通员工头像上传的地址
        * @Author:      TJX
         * @param username
         * @param image
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-08 18:31
        */
        return userService.uploadImage(username,image);
    }
}
