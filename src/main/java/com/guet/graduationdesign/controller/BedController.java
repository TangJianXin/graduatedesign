package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    public List<Bed> findAll()
    {
        /**
        * @Description: 查询所有床位信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Bed>
        * @Exception
        * @Date        2019-04-26 16:08
        */
        return bedService.findAll();
    }

    @GetMapping(value = "/findById")
    public Bed findBedById(@RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 根据床位Id查询床位信息
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-26 16:11
        */
        return bedService.findById(bedId);
    }

    @DeleteMapping(value = "/deleteById")
    public String deleteBedById(@RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 根据床位Id删除床位
        * @Author:      TJX
         * @param bedId
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-26 16:14
        */
        bedService.deleteById(bedId);
        return "删除成功";
    }

    @PutMapping(value = "/modifyInformation")
    public Bed modifyBedInformation(@RequestParam("bedId") String bedId,
                                    @RequestParam("oldPeopleId") Integer oldPeopleId,
                                    @RequestParam("employerId") Integer employerId)
    {
        /**
        * @Description: 修改床位信息
        * @Author:      TJX
         * @param bedId
         * @param employerId
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-26 16:16
        */
        return bedService.update(bedId,oldPeopleId,employerId);
    }

    @PostMapping(value = "/add")
    public Bed add(@RequestParam("bedId") String bedId)
    {
        /**
        * @Description: 添加床位
        * @Author:      TJX
         * @param bedId
         * @param employerId
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-26 16:18
        */
        return bedService.add(bedId);
    }

    @PostMapping(value = "/setAdmin")
    public Bed setAdmin(String bedId,Integer employerId)
    {
        /**
        * @Description: 设置床位管理人员
        * @Author:      TJX
         * @param bedId
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-27 21:03
        */
        return bedService.setAdminEmployer(bedId,employerId);
    }

    @PostMapping(value = "/setOldPeople")
    public Bed setOldPeople(String bedId,Integer oldPeopleId)
    {
        /**
        * @Description: 设置床位使用老人
        * @Author:      TJX
         * @param bedId
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-27 21:03
        */
        return bedService.setUserOldPeople(bedId,oldPeopleId);
    }
}
