package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public User register(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("employerId") Integer employerId)
    {
       return userService.register(username,password,employerId);
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password)
    {
        return userService.login(username,password);
    }

    @GetMapping(value = "/findAll")
    public ArrayList<User> findAll()
    {
        return userService.findAll();
    }
    @PostMapping(value = "/getInformation")
    public Employer getInformationByUsername(@RequestParam("username") String username)
    {
        return userService.getEmployerByUsername(username);
    }
}
