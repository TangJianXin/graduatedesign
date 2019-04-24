package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

}
