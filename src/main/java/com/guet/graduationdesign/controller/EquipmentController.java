package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result findAll()
    {
        /**
        * @Description: 查询所有设备
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:32
        */
        return equipmentService.findAll();
    }

    @GetMapping(value = "/findById")
    public Result findEquipmentById(@RequestParam("equipmentId") Integer equipmentId)
    {
        /**
        * @Description: 根据设备编号查询所有设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:33
        */
        return equipmentService.findById(equipmentId);
    }

    @DeleteMapping(value = "/deleteById")
    public Result deleteEquipmentById(@RequestBody Equipment equipment)
    {
        /**
        * @Description: 根据Id删除设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:56
        */
        return equipmentService.deleteById(equipment.getEquipmentId());
    }

    @PutMapping(value = "/modifyInformation")
    public Result modifyEquipmentInformation(@RequestParam("equipmentId") Integer equipmentId,
                                                @RequestParam("equipmentName") String equipmentName,
                                                @RequestParam("purchaseDate") String purchaseDate,
                                                @RequestParam("productionDate") String productionDate,
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
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:40
        */
        return equipmentService.update(equipmentId,equipmentName,purchaseDate,productionDate,departmentId);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestParam("equipmentName") String equipmentName,
                         @RequestParam("purchaseDate") String purchaseDate,
                         @RequestParam("productionDate") String productionDate,
                         @RequestParam("departmentId") String departmentId)
    {
        /**
        * @Description: 添加设备
        * @Author:      TJX
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:39
        */
        return equipmentService.add(equipmentName,purchaseDate,productionDate,departmentId);
    }
}
