package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.UserRepository;
import com.guet.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<User> findAll() {
        /**
        * @Description: 查询所有普通员工账号信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.User>
        * @Exception
        * @Date        2019-04-24 20:54
        */
         return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        /**
        * @Description: 根据用户名查询普通员工账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-24 20:53
        */
        return userRepository.getOne(username);
    }

    @Transactional
    @Override
    public void deleteByUsername(String username) {
        /**
        * @Description: 根据用户名删除普通员工账号
        * @Author:      TJX
         * @param username
        * @Return      void
        * @Exception
        * @Date        2019-04-24 20:52
        */
        userRepository.deleteById(username);
    }

    @Transactional
    @Override
    public User update(String username, String password, Integer employerId) {
        /**
        * @Description: 修改密码
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-24 20:50
        */
        return add(username,password,employerId);
    }

    @Transactional
    @Override
    public User add(String username, String password, Integer employerId)
    {
        /**
        * @Description: 普通员工账号
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception   
        * @Date        2019-04-24 20:48
        */
        User user = getUser(username,password,employerId);
        return userRepository.save(user);
    }

    @Override
    public User findByEmployerId(Integer employerId) {
        /**
        * @Description: 根据员工Id查询普通员工账号密码
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-27 17:21
        */
        List<User> list = findAll();
        for(User user:list)
        {
            if(user.getEmployerByEmployerId().getEmployerId()==employerId)
            {
                return user;
            }
        }
        return null;
    }

    private User getUser(String username,String password,Integer employerId)
    {
        /**
        * @Description: 构造普通员工账号对象
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-24 20:50
        */
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Employer employer = employerRepository.getOne(employerId);
        user.setEmployerByEmployerId(employer);
        return user;
    }
}
