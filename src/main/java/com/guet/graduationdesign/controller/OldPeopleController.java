package com.guet.graduationdesign.controller;

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

    @DeleteMapping(value = "/deleteById")
    public Result deleteOldPeopleById(@RequestParam("oldPeopleId") Integer oldPeopleId)
    {
        /**
        * @Description: 根据Id删除老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:57
        */
        return oldPeopleService.delete(oldPeopleId);
    }

    @PutMapping(value = "/modifyInformation")
    public Result modifyOldPeopleInformation(@RequestParam("oldPeopleId") Integer oldPeopleId,
                                                @RequestParam("idCard") String idCard,
                                                @RequestParam("photo") String photo,
                                                @RequestParam("name") String name,
                                                @RequestParam("telephone") String telephone,
                                                @RequestParam("address") String address,
                                                @RequestParam("sex") String sex,
                                                @RequestParam("birthday") String birthday,
                                                @RequestParam("familyPhone") String familyPhone
                                                )
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
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 17:07
        */
        return oldPeopleService.update(oldPeopleId,idCard,photo,name,telephone,address,sex,birthday,familyPhone);
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
