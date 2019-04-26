package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
* @Description:    设备管理控制器
* @Author:         TJX
* @CreateDate:     2019-04-26 11:53
* @UpdateUser:
* @UpdateDate:     2019-04-26 11:53
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping(value = "/findAll")
    public List<Equipment> findAll()
    {
        /**
        * @Description: 查询所有设备
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Equipment>
        * @Exception
        * @Date        2019-04-26 16:32
        */
        return equipmentService.findAll();
    }

    @PostMapping(value = "/findById")
    public Equipment findEquipmentById(@RequestParam("equipmentId") String equipmentId)
    {
        /**
        * @Description: 根据设备编号查询所有设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-26 16:33
        */
        return equipmentService.findById(equipmentId);
    }

    @DeleteMapping(value = "/deleteById")
    public String deleteEquipmentById(@RequestParam("equipmentId") String equipmentId)
    {
        /**
        * @Description: 根据设备Id删除设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-26 16:34
        */
        equipmentService.deleteById(equipmentId);
        return "删除成功";
    }

    @PostMapping(value = "/modifyInformation")
    public Equipment modifyEquipmentInformation(@RequestParam("equipmentId") String equipmentId,
                                                @RequestParam("equipmentName") String equipmentName,
                                                @RequestParam("purchaseDate") Date purchaseDate,
                                                @RequestParam("productionDate") Date productionDate,
                                                @RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 修改设备信息
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-26 16:40
        */
        return equipmentService.update(equipmentId,equipmentName,purchaseDate,productionDate,departmentId);
    }

    @PostMapping(value = "/add")
    public Equipment add(@RequestParam("equipmentId") String equipmentId,
                         @RequestParam("equipmentName") String equipmentName,
                         @RequestParam("purchaseDate") Date purchaseDate,
                         @RequestParam("productionDate") Date productionDate,
                         @RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 添加设备
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-26 16:39
        */
        return equipmentService.add(equipmentId,equipmentName,purchaseDate,productionDate,departmentId);
    }
}
