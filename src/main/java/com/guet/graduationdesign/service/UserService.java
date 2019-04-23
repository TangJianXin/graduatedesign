package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.User;

import java.util.ArrayList;

public interface UserService {

    public User register(String username, String password, Integer employerId);
    public String login(String username,String password);
    public ArrayList<User> findAll();
    public Employer getEmployerByUsername(String username);
}
