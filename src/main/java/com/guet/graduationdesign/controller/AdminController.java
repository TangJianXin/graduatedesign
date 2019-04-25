package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Admin> findAll()
    {
        /**
         * @Description: 查询所有管理员账号
         * @Author:      TJX
         * @param
         * @Return      java.util.List<com.guet.graduationdesign.pojo.Admin>
         * @Exception
         * @Date        2019-04-25 10:14
         */
        return adminService.findAll();
    }

    @PostMapping(value = "/findByUsername")
    public Admin findByUsername(@RequestParam("username") String username)
    {
        /**
         * @Description: 根据用户名查询管理员账号信息
         * @Author:      TJX
         * @param username
         * @Return      com.guet.graduationdesign.pojo.Admin
         * @Exception
         * @Date        2019-04-25 10:15
         */
        Admin admin = adminService.findByUsername(username);
        System.out.println(admin.getEmployerByEmployerId().getName());
        return admin;
    }

    @DeleteMapping(value = "/deleteByUsername")
    public String deleteByUsername(@RequestParam("username") String username)
    {
        /**
         * @Description: 根据用户名删除管理员账号
         * @Author:      TJX
         * @param username
         * @Return      void
         * @Exception
         * @Date        2019-04-25 10:19
         */
        adminService.deleteByUsername(username);
        return "删除成功";
    }

    @PostMapping("/modifyPassword")
    public Admin modifyPassword(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("employerId") Integer employerId)
    {
        /**
         * @Description: 修改管理员密码
         * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
         * @Return      com.guet.graduationdesign.pojo.Admin
         * @Exception
         * @Date        2019-04-25 10:22
         */
        return adminService.update(username,password,employerId);
    }

    @PostMapping("/register")
    public Admin register(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("employerId") Integer employerId)
    {
        /**
         * @Description: 管理员账号注册
         * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
         * @Return      com.guet.graduationdesign.pojo.Admin
         * @Exception
         * @Date        2019-04-25 10:23
         */
        return adminService.add(username,password,employerId);
    }
}
