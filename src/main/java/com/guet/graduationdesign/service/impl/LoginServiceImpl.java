package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.repository.AdminRepository;
import com.guet.graduationdesign.repository.UserRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.LoginService;
import com.guet.graduationdesign.util.ResultUtil;
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
    public Result loginByAdmin(String username, String password)throws MyException {
       /**
       * @Description: 管理员登录
       * @Author:      TJX
        * @param username
        * @param password
       * @Return      com.guet.graduationdesign.result.Result
       * @Exception
       * @Date        2019-05-02 21:43
       */
        Admin admin;
        try{
            if(adminRepository.existsById(username))
            {
                admin = adminRepository.getOne(username);
                if(admin.getPassword().equals(password))
                {
                    return ResultUtil.success(ResultEnum.LOGIN_SUCCESS,admin);
                }
                else
                {
                    throw new MyException(ResultEnum.LOGIN_FAIL);
                }
            }
            else {
                throw new MyException(ResultEnum.LOGIN_FAIL);
            }
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.LOGIN_FAIL);
        }
    }

    @Override
    public Result loginByUser(String username, String password)throws MyException {
        /**
        * @Description: 普通员工登录
        * @Author:      TJX
         * @param username
         * @param password
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:43
        */
        User user;
        try{
            if(userRepository.existsById(username))
            {
                user = userRepository.getOne(username);
                if(user.getPassword().equals(password))
                {
                    return ResultUtil.success(ResultEnum.LOGIN_SUCCESS,user);
                }
                else{
                    throw new MyException(ResultEnum.LOGIN_FAIL);
                }
            }
            else{
                throw new MyException(ResultEnum.LOGIN_FAIL);
            }
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.LOGIN_FAIL);
        }
    }
}
