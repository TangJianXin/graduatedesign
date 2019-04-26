package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
