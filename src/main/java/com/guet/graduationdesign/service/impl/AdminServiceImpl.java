package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.repository.AdminRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Override
    public Admin register(String adminname, String password, Integer employerId) {
        Admin admin = new Admin();
        admin.setAdminname(adminname);
        admin.setPassword(password);
        Employer employer = employerRepository.getOne(employerId);
        admin.setEmployerByEmployerId(employer);
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public String login(String adminname, String password) {
        Admin admin;
        if(adminRepository.existsById(adminname))
        {
            admin = adminRepository.getOne(adminname);
            if(admin.getPassword().equals(password))
            {
                return "登录成功";
            }
            else
            {
                return "密码错误";
            }
        }
        else {
            return "账号错误";
        }
    }

    @Override
    public ArrayList<Admin> findAll() {
        return (ArrayList<Admin>) adminRepository.findAll();
    }

    @Override
    public Employer getEmployerByAdminname(String adminname) {
        Admin admin = adminRepository.getOne(adminname);
        return admin.getEmployerByEmployerId();
    }
}
