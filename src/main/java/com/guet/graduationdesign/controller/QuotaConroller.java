package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    体征指标控制器
* @Author:         TJX
* @CreateDate:     2019-05-13 19:01
* @UpdateUser:
* @UpdateDate:     2019-05-13 19:01
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/quota")
public class QuotaConroller {

    @Autowired
    private QuotaService quotaService;

    @GetMapping(value = "/findAll")
    public Result findAll()
    {
        /**
        * @Description: 查询所有体征记录
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 19:02
        */
        return quotaService.findAll();
    }

    @PostMapping(value = "/deleteById")
    public Result deleteById(Integer quotaId)
    {
        /**
        * @Description: 根据Id删除体征指标记录
        * @Author:      TJX
         * @param quotaId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 19:03
        */
        return quotaService.deleteById(quotaId);
    }

    @GetMapping(value = "/findByName")
    public Result findByName(String name)
    {
        /**
        * @Description: 通过老人姓名查询体征记录
        * @Author:      TJX
         * @param name
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 19:04
        */
        return quotaService.findByName(name);
    }
}
