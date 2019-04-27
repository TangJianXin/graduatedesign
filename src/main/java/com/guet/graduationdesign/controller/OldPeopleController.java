package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.OldPeople;
import com.guet.graduationdesign.service.OldPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

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
    public List<OldPeople> findAll()
    {
        /**
        * @Description: 查询所有老人信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.OldPeople>
        * @Exception
        * @Date        2019-04-26 16:52
        */
        return oldPeopleService.findAll();
    }

    @PostMapping(value = "/findById")
    public OldPeople findOldPeopleById(@RequestParam("oldPeopleId") Integer oldPeopleId)
    {
        /**
        * @Description: 根据老人Id查询老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-26 16:57
        */
        return oldPeopleService.findById(oldPeopleId);
    }

    @DeleteMapping(value = "/deleteById")
    public String deleteOldPeopleById(@RequestParam("oldPeopleId") Integer oldPeopleId)
    {
        /**
        * @Description: 根据老人Id删除老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-26 17:00
        */
        oldPeopleService.delete(oldPeopleId);
        return "删除成功";
    }

    @PostMapping(value = "/modifyInformation")
    public OldPeople modifyOldPeopleInformation(@RequestParam("oldPeopleId") Integer oldPeopleId,
                                                @RequestParam("idCard") String idCard,
                                                @RequestParam("photo") MultipartFile photo,
                                                @RequestParam("name") String name,
                                                @RequestParam("telephone") String telephone,
                                                @RequestParam("address") String address,
                                                @RequestParam("sex") String sex,
                                                @RequestParam("birthday") Date birthday,
                                                @RequestParam("familyPhone") String familyPhone,
                                                @RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 修改老人信息
        * @Author:      TJX
         * @param oldPeopleId
         * @param idCard
         * @param photo
         * @param name
         * @param telephone
         * @param address
         * @param sex
         * @param birthday
         * @param familyPhone
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-26 17:07
        */
        return oldPeopleService.update(oldPeopleId,idCard,photo,name,telephone,address,sex,birthday,familyPhone);
    }

    @PostMapping(value = "/add")
    public OldPeople add(@RequestParam("idCard") String idCard,
                         @RequestParam("photo")MultipartFile photo,
                         @RequestParam("name") String name,
                         @RequestParam("telephone") String telephone,
                         @RequestParam("address") String address,
                         @RequestParam("sex") String sex,
                         @RequestParam("birthday") Date birthday,
                         @RequestParam("familyPhone") String familyPhone)
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
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-26 17:07
        */
        return oldPeopleService.add(idCard,photo,name,telephone,address,sex,birthday,familyPhone);
    }
}
