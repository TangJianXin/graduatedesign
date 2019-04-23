package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.UserRepository;
import com.guet.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Override
    public User register(String username, String password, Integer employerId) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Employer employer = employerRepository.getOne(employerId);
        user.setEmployerByEmployerId(employer);
        userRepository.save(user);
        return user;
    }

    @Override
    public String login(String username, String password) {
        User user;
        if(userRepository.existsById(username))
        {
           user = userRepository.getOne(username);
           if(user.getPassword().equals(password))
           {
               return "登录成功";
           }
           else{
               return "密码错误";
           }
        }
        else{
            return "账号错误";
        }
    }

    @Override
    public ArrayList<User> findAll() {
         return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public Employer getEmployerByUsername(String username) {
        User user = userRepository.getOne(username);
        return user.getEmployerByEmployerId();
    }
}
