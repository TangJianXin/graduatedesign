package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.repository.AdminRepository;
import com.guet.graduationdesign.repository.UserRepository;
import com.guet.graduationdesign.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:   登录service
* @Author:         TJX
* @CreateDate:     2019-04-24 20:58
* @UpdateUser:
* @UpdateDate:     2019-04-24 20:58
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Admin loginByAdmin(String username, String password) {
       /**
       * @Description: 管理员登录
       * @Author:      TJX
        * @param username
        * @param password
        * @param employerId
       * @Return      com.guet.graduationdesign.pojo.Admin
       * @Exception
       * @Date        2019-04-24 21:02
       */
        Admin admin;
        if(adminRepository.existsById(username))
        {
            admin = adminRepository.getOne(username);
            if(admin.getPassword().equals(password))
            {
                return admin;
            }
            else
            {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public User loginByUser(String username, String password) {
        /**
        * @Description: 普通员工登录
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.User
        * @Exception
        * @Date        2019-04-24 21:02
        */
        User user;
        if(userRepository.existsById(username))
        {
            user = userRepository.getOne(username);
            if(user.getPassword().equals(password))
            {
                return user;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
