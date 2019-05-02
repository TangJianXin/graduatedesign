package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.repository.AdminRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.AdminService;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* @Description:    管理员账号service
* @Author:         TJX
* @CreateDate:     2019-04-24 20:21
* @UpdateUser:
* @UpdateDate:     2019-04-24 20:21
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Result findAll() throws MyException {
        /**
        * @Description: 查询所有管理员账号
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:33
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,adminRepository.findAll());
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findByUsername(String username) throws MyException{
        /**
        * @Description: 根据用户名查询管理员账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:33
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,adminRepository.getOne(username));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result deleteByUsername(String username) throws MyException {
        /**
        * @Description: 根据用户名删除管理员账号
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:33
        */
        try{
            adminRepository.deleteById(username);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result update(String username,String password,Integer employerId) throws MyException{
        /**
        * @Description: 修改密码
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:34
        */
        Admin admin = getAdmin(username,password,employerId);
        try{
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,adminRepository.save(admin));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String username, String password, Integer employerId) throws MyException {
        /**
        * @Description: 添加管理员账号
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:34
        */
        Admin admin = getAdmin(username,password,employerId);
        try{
            return ResultUtil.success(ResultEnum.REGISTER_SUCCESS,adminRepository.save(admin));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.REGISTER_FAIL);
        }
    }

    @Override
    public Result findByEmployerId(Integer employerId) throws MyException{
        /**
        * @Description: 根据员工Id查询管理员账号
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:34
        */
        try{
            List<Admin> list = adminRepository.findAll();
            for(Admin admin:list)
            {
                if(admin.getEmployerByEmployerId().getEmployerId()==employerId) {
                    return ResultUtil.success(ResultEnum.SELECT_SUCCESS, admin);
                }

            }
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS);
    }

    private Admin getAdmin(String username,String password,Integer employerId)
    {
        /**
        * @Description: 构造管理员账号对象
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Admin
        * @Exception
        * @Date        2019-04-24 20:39
        */
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Employer employer = employerRepository.getOne(employerId);
        admin.setEmployerByEmployerId(employer);
        return admin;
    }

}
