package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
}
