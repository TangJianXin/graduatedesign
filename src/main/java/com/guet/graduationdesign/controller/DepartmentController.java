package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Department;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping("/findAll")
    public List<Department> findAll()
    {
        /**
        * @Description: 查询所有部门
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Department>
        * @Exception
        * @Date        2019-04-26 11:36
        */
        return departmentService.findAll();
    }

    @PostMapping(value = "/findById")
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

    @DeleteMapping("/deleteById")
    public String deleteDepartmentById(String departmentId)
    {
        /**
        * @Description: 根据部门Id删除部门
        * @Author:      TJX
         * @param departmentId
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-26 11:38
        */
        departmentService.deleteById(departmentId);
        return "删除成功";
    }

    @PostMapping("/modifyInformation")
    public Department modifyDepartmentInformation(@RequestParam("departmentId") String departmentId,
                                                  @RequestParam("departmentName") String departmentName)
    {
        /**
        * @Description: 修改部门信息
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-26 11:42
        */
        return departmentService.update(departmentId,departmentName);
    }

    @PostMapping("/add")
    public Department add(@RequestParam("departmentId") String departmentId,
                          @RequestParam("departmentName") String departmentName)
    {
        /**
        * @Description: 添加部门信息
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-26 11:44
        */
        return departmentService.add(departmentId,departmentName);
    }

    @PostMapping(value = "/findAllEmployer")
    public List<Employer> findAllEmployerById(@RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 查询部门所有员工
        * @Author:      TJX
         * @param departmentId
        * @Return      java.util.ArrayList<com.guet.graduationdesign.pojo.Employer>
        * @Exception
        * @Date        2019-04-27 16:46
        */
        return departmentService.findAllEmployer(departmentId);
    }

    @PostMapping(value = "/findAllEquipment")
    public List<Equipment> findAllEquipmentById(@RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 查询部门所有设备
        * @Author:      TJX
         * @param departmetId
        * @Return      java.util.ArrayList<com.guet.graduationdesign.pojo.Equipment>
        * @Exception
        * @Date        2019-04-27 16:49
        */
        return departmentService.findAllEquipment(departmentId);
    }
}
