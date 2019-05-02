package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:    管理员账号管理控制器
 * @Author:         TJX
 * @CreateDate:     2019-04-25 10:13
 * @UpdateUser:
 * @UpdateDate:     2019-04-25 10:13
 * @UpdateRemark:
 * @Version:        1.0
 */
@RequestMapping(value = "/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/findAll")
    public Result findAll()
    {
        /**
         * @Description: 查询所有管理员账号
         * @Author:      TJX
         * @param
         * @Return      com.guet.graduationdesign.result.Result
         * @Exception
         * @Date        2019-04-25 10:14
         */
        return adminService.findAll();
    }

    @GetMapping(value = "/findByUsername")
    public Result findByUsername(@RequestParam("username") String username)
    {
        /**
         * @Description: 根据用户名查询管理员账号信息
         * @Author:      TJX
         * @param username
         * @Return      com.guet.graduationdesign.result.Result
         * @Exception
         * @Date        2019-04-25 10:15
         */
        return adminService.findByUsername(username);
    }

    @DeleteMapping(value = "/deleteByUsername")
    public Result deleteByUsername(@RequestParam("username") String username)
    {
        /**
        * @Description: 根据用户名删除管理员账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:49
        */
        return adminService.deleteByUsername(username);
    }

    @PutMapping("/modifyPassword")
    public Result modifyPassword(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("employerId") Integer employerId)
    {
        /**
         * @Description: 修改管理员密码
         * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
         * @Return      com.guet.graduationdesign.result.Result
         * @Exception
         * @Date        2019-04-25 10:22
         */
        return adminService.update(username,password,employerId);
    }

    @PostMapping("/register")
    public Result register(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("employerId") Integer employerId)
    {
        /**
         * @Description: 管理员账号注册
         * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
         * @Return      com.guet.graduationdesign.result.Result
         * @Exception
         * @Date        2019-04-25 10:23
         */
        return adminService.add(username,password,employerId);
    }

    @GetMapping(value = "/findByEmployerId")
    public Result findAdminByEmployerId(@RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 根据员工Id查询管理员账号密码
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-27 17:16
        */
        return adminService.findByEmployerId(employerId);
    }
}
