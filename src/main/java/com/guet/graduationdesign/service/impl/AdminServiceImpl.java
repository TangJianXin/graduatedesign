package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.repository.AdminRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Admin> findAll() {
        /**
        * @Description: 查询所有管理员账号信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Admin>
        * @Exception
        * @Date        2019-04-24 20:44
        */
        return adminRepository.findAll();
    }

    @Override
    public Admin findByUsername(String username) {
        /**
        * @Description: 根据用户名查询管理员账号信息
        * @Author:      TJX
         * @param username
        * @Return      com.guet.graduationdesign.pojo.Admin
        * @Exception
        * @Date        2019-04-24 20:44
        */
        return adminRepository.getOne(username);
    }

    @Override
    public void deleteByUsername(String username) {
        /**
        * @Description: 根据用户名删除管理账号
        * @Author:      TJX
         * @param username
        * @Return      void
        * @Exception
        * @Date        2019-04-24 20:43
        */
        adminRepository.deleteById(username);
    }

    @Override
    public Admin update(String username,String password,Integer employerId) {
        /**
        * @Description: 修改账号
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Admin
        * @Exception
        * @Date        2019-04-24 20:42
        */
        return add(username,password,employerId);
    }

    @Override
    public Admin add(String username, String password, Integer employerId) {
        /**
        * @Description: 管理员账号注册
        * @Author:      TJX
         * @param username
         * @param password
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Admin
        * @Exception
        * @Date        2019-04-24 20:39
        */
        Admin admin = getAdmin(username,password,employerId);
        return adminRepository.save(admin);
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
