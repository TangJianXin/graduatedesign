package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.OldPeople;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.OldPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @Description:    老人管理控制器
* @Author:         TJX
* @CreateDate:     2019-04-26 16:51
* @UpdateUser:
* @UpdateDate:     2019-04-26 16:51
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/oldPeople")
public class OldPeopleController {

    @Autowired
    private OldPeopleService oldPeopleService;

    @GetMapping(value = "/findAll")
    public Result findAll()
    {
        /**
        * @Description: 查询所有老人信息
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:52
        */
        return oldPeopleService.findAll();
    }

    @GetMapping(value = "/findByName")
    public Result findByName(@RequestParam("name") String name)
    {
        /**
        * @Description: 根据老人姓名查询老人
        * @Author:      TJX
         * @param name
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-14 10:54
        */
        return oldPeopleService.findByName(name);
    }

    @GetMapping(value = "/getAge")
    public Result getAge()
    {
        /**
        * @Description: 获取老人年龄分布
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-14 20:44
        */
        return oldPeopleService.getAge();
    }

    @GetMapping(value = "/findAllEmpty")
    public Result findAllEmpty()
    {
        /**
        * @Description: 查询所有未安排床位的老人
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-07 17:47
        */
        return oldPeopleService.findAllEmpty();
    }

    @GetMapping(value = "/findById")
    public Result findOldPeopleById(@RequestParam("oldPeopleId") Integer oldPeopleId)
    {
        /**
        * @Description: 根据老人Id查询老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:57
        */
        return oldPeopleService.findById(oldPeopleId);
    }

    @PostMapping(value = "/deleteById")
    public Result deleteOldPeopleById(@RequestParam("oldPeopleId") Integer oldPeopleId)
    {
        /**
        * @Description: 根据Id删除老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 12:22
        */
        return oldPeopleService.delete(oldPeopleId);
    }

    @PutMapping(value = "/modifyInformation")
    public Result modifyOldPeopleInformation(@RequestParam("idCard") String idCard,
                                             @RequestParam("oldPeopleId") Integer oldPeopleId,
                                                @RequestParam("photo") String photo,
                                                @RequestParam("name") String name,
                                                @RequestParam("telephone") String telephone,
                                                @RequestParam("address") String address,
                                                @RequestParam("sex") String sex,
                                                @RequestParam("birthday") String birthday,
                                                @RequestParam("familyPhone") String familyPhone,
                                                @RequestParam("entryDate") String entryDate
                                                )
    {
        /**
        * @Description: 修改老人信息
        * @Author:      TJX
         * @param idCard
         * @param oldPeopleId
         * @param photo
         * @param name
         * @param telephone
         * @param address
         * @param sex
         * @param birthday
         * @param familyPhone
         * @param entryDate
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-06 00:32
        */
        return oldPeopleService.update(oldPeopleId,idCard,photo,name,telephone,address,sex,birthday,familyPhone,entryDate);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestParam("idCard") String idCard,
                         @RequestParam("photo")String photo,
                         @RequestParam("name") String name,
                         @RequestParam("telephone") String telephone,
                         @RequestParam("address") String address,
                         @RequestParam("sex") String sex,
                         @RequestParam("birthday") String birthday,
                         @RequestParam("familyPhone") String familyPhone,
                         @RequestParam("entryDate") String entryDate)
    {
        /**
        * @Description: 添加老人信息
        * @Author:      TJX
         * @param idCard
         * @param photo
         * @param name
         * @param telephone
         * @param address
         * @param sex
         * @param birthday
         * @param familyPhone
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 17:07
        */
        return oldPeopleService.add(idCard,photo,name,telephone,address,sex,birthday,familyPhone,entryDate);
    }
}
