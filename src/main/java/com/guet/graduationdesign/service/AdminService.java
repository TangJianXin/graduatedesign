package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.Employer;

import java.util.ArrayList;

public interface AdminService {

    public Admin register(String adminname, String password, Integer employerId);
    public String login(String adminname,String password);
    public ArrayList<Admin> findAll();
    public Employer getEmployerByAdminname(String adminname);
}
