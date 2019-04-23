package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(value = "/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/register")
    public Admin register(@RequestParam("adminname") String adminname,
                          @RequestParam("password") String password,
                          @RequestParam("employerId") Integer employerId)
    {
       return adminService.register(adminname,password,employerId);
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("adminname") String adminname,
                        @RequestParam("password") String password)
    {
        return adminService.login(adminname,password);
    }

    @GetMapping(value = "/findAll")
    public ArrayList<Admin> findAll()
    {
        return adminService.findAll();
    }

    @PostMapping(value = "/getInformation")
    public Employer getInformationByAdminname(@RequestParam("adminname") String adminname)
    {
        return adminService.getEmployerByAdminname(adminname);
    }

}
