package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Department;
import com.guet.graduationdesign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    部门管理控制器
* @Author:         TJX
* @CreateDate:     2019-04-25 21:09
* @UpdateUser:
* @UpdateDate:     2019-04-25 21:09
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/findDepartmentById")
    public Department findDepartmentById(@RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 根据部门Id查询部门信息
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-25 21:10
        */
        return departmentService.findById(departmentId);
    }
}
