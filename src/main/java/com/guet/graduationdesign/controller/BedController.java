package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/findAll")
    public Result findAll()
    {
        /**
        * @Description: 查询所有床位信息
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:08
        */
        return bedService.findAll();
    }

    @GetMapping(value = "/findById")
    public Result findBedById(@RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 根据床位Id查询床位信息
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:11
        */
        return bedService.findById(bedId);
    }

    @DeleteMapping(value = "/deleteById")
    public Result deleteBedById(@RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 根据Id删除床位
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:50
        */
        return bedService.deleteById(bedId);
    }

    @PutMapping(value = "/modifyInformation")
    public Result modifyBedInformation(@RequestParam("bedId") String bedId,
                                    @RequestParam("oldPeopleId") Integer oldPeopleId,
                                    @RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 修改床位信息
        * @Author:      TJX
         * @param bedId
         * @param employerId
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:16
        */
        return bedService.update(bedId,oldPeopleId,employerId);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 添加床位
        * @Author:      TJX
         * @param bedId
         * @param employerId
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-26 16:18
        */
        return bedService.add(bedId);
    }

    @PostMapping(value = "/setAdmin")
    public Result setAdmin(String bedId,Integer employerId)
    {
        /**
        * @Description: 设置床位管理人员
        * @Author:      TJX
         * @param bedId
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-27 21:03
        */
        return bedService.setAdminEmployer(bedId,employerId);
    }

    @PostMapping(value = "/setOldPeople")
    public Result setOldPeople(String bedId,Integer oldPeopleId)
    {
        /**
        * @Description: 设置床位使用老人
        * @Author:      TJX
         * @param bedId
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-27 21:03
        */
        return bedService.setUserOldPeople(bedId,oldPeopleId);
    }
}
