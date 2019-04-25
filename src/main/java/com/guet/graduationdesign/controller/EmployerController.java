package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:    员工管理控制器
* @Author:         TJX
* @CreateDate:     2019-04-25 21:16
* @UpdateUser:
* @UpdateDate:     2019-04-25 21:16
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping(value = "//findAll")
    public List<Employer> findAll()
    {
        /**
        * @Description: 查询所有员工信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Employer>
        * @Exception
        * @Date        2019-04-25 21:16
        */
        return employerService.findAll();
    }
}
