package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Department;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result findAll()
    {
        /**
        * @Description: 查询所有部门
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 11:36
        */
        return departmentService.findAll();
    }

    @GetMapping(value = "/findById")
    public Result findDepartmentById(@RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 根据部门Id查询部门信息
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-25 21:10
        */
        return departmentService.findById(departmentId);
    }

    @DeleteMapping("/deleteById")
    public Result deleteDepartmentById(@RequestBody Department department)
    {
        /**
        * @Description: 根据Id删除部门
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:52
        */
        return departmentService.deleteById(department.getDepartmentId());
    }

    @PutMapping("/modifyInformation")
    public Result modifyDepartmentInformation(@RequestParam("departmentId") String departmentId,
                                                  @RequestParam("departmentName") String departmentName)
    {
        /**
        * @Description: 修改部门信息
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 11:42
        */
        return departmentService.update(departmentId,departmentName);
    }

    @PostMapping("/add")
    public Result add(@RequestParam("departmentId") String departmentId,
                          @RequestParam("departmentName") String departmentName)
    {
        /**
        * @Description: 添加部门信息
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 11:44
        */
        return departmentService.add(departmentId,departmentName);
    }

    @GetMapping(value = "/findAllEmployer")
    public Result findAllEmployerById(@RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 查询部门所有员工
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-27 16:46
        */
        return departmentService.findAllEmployer(departmentId);
    }

    @GetMapping(value = "/findAllEquipment")
    public Result findAllEquipmentById(@RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 查询部门所有设备
        * @Author:      TJX
         * @param departmetId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-27 16:49
        */
        return departmentService.findAllEquipment(departmentId);
    }

    @GetMapping(value = "/getCount")
    public Result getCount()
    {
        /**
        * @Description: 查询部门人数和设备数量
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-30 18:32
        */
        return departmentService.findAllPeopleAndEquipment();
    }
}
