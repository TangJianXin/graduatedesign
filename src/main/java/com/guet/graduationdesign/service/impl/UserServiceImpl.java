package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.User;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.UserRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.UserService;
import com.guet.graduationdesign.util.ResultUtil;
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
    public Result findAll() throws MyException {
        /**
        * @Description: 查询所有普通员工账号
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:45
        */
         try{
             return ResultUtil.success(ResultEnum.SELECT_SUCCESS,userRepository.findAll());
         }catch (Exception e)
         {
             throw new MyException(ResultEnum.SELETCT_FAIL);
         }

    }

    @Override
    public Result findByUsername(String username)throws MyException {
        /**
        * @Description: 根据用户名查询普通员工账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:45
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,userRepository.getOne(username));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result deleteByUsername(String username)throws MyException {
        /**
        * @Description: 根据用户名删除普通员工账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:45
        */
        try{
            userRepository.deleteById(username);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }

    }

    @Transactional
    @Override
    public Result update(String username, String password, Integer employerId)throws MyException {
        /**
        * @Description: 修改密码
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:46
        */
        User user = getUser(username,password,employerId);
        try{
            return ResultUtil.success(ResultEnum.UPLOAD_SUCCESS,userRepository.save(user));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String username, String password, Integer employerId)throws MyException
    {
        /**
        * @Description: 添加普通员工账号
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:46
        */
        User user = getUser(username,password,employerId);
        try{
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,userRepository.save(user));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    @Override
    public Result findByEmployerId(Integer employerId)throws MyException {
        /**
        * @Description: 根据员工Id查询普通员工账号
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:47
        */
        try{
            List<User> list = userRepository.findAll();
            for(User user:list)
            {
                if(user.getEmployerByEmployerId().getEmployerId()==employerId)
                {
                    return ResultUtil.success(ResultEnum.SELECT_SUCCESS,user);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
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
