package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* @Description:    床位管理控制器
* @Author:         TJX
* @CreateDate:     2019-04-26 11:52
* @UpdateUser:
* @UpdateDate:     2019-04-26 11:52
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/bed")
public class BedController {

    @Autowired
    private BedService bedService;
}
