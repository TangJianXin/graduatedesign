package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/findAll")
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

    @GetMapping("/findById")
    public Employer findByEmployerId(@RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 根据工号查询员工信息
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-26 09:51
        */
        return employerService.findById(employerId);
    }

    @DeleteMapping(value = "deleteById")
    public String deleteByEmployerId(@RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 根据工号删除员工信息
        * @Author:      TJX
         * @param employerId
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-26 09:52
        */
        employerService.deleteById(employerId);
        return "删除成功";
    }


    @PutMapping("/modifyInformation")
    public Employer modifyEmployerInformation(@RequestParam("employerId") Integer employerId,
                                              @RequestParam("position") String position,
                                              @RequestParam("name") String name,
                                              @RequestParam("telephone") String telephone,
                                              @RequestParam("address") String address,
                                              @RequestParam("idCard") String idCard,
                                              @RequestParam("birthday") String birthday,
                                              @RequestParam("photo") String photo,
                                              @RequestParam("sex") String sex,
                                              @RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 修改员工信息
        * @Author:      TJX
         * @param employerId
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-26 09:59
        */
        return employerService.update(employerId,position,name,telephone,address,idCard,birthday,photo,sex,departmentId);
    }

    @PostMapping(value = "/add")
    public Employer add(@RequestParam("photo") String photo,
                        @RequestParam("position") String position,
                        @RequestParam("name") String name,
                        @RequestParam("telephone") String telephone,
                        @RequestParam("address") String address,
                        @RequestParam("idCard") String idCard,
                        @RequestParam("birthday") String birthday,
                        @RequestParam("sex") String sex,
                        @RequestParam("departmentId") String departmentId,
                        @RequestParam("entryDate") String entryDate)
    {
        /**
        * @Description: 添加员工信息
        * @Author:      TJX
         * @param employerId
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-26 10:00
        */
        return employerService.add(position,name,telephone,address,idCard,birthday,photo,sex,departmentId,entryDate);
    }

    @GetMapping(value = "/findAllBedById")
    public List<Bed> findAllBedByEmployerId(@RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 根据员工Id查询管理的所有床位
        * @Author:      TJX
         * @param employerId
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Bed>
        * @Exception
        * @Date        2019-04-27 20:33
        */
        return employerService.findAllBedById(employerId);
    }

}
