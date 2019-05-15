package com.guet.graduationdesign.controller;


import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private SchedulerService schedulerService;

    @PostMapping(value = "/start")
    public Result start(@RequestParam("oldPeopleId") Integer oldPeopleId)
    {
        /**
        * @Description: 开启采集
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-05-15 22:36
        */
       return schedulerService.start(oldPeopleId);
    }

    @PostMapping(value = "/stop")
    public Result stop()
    {
        /**
        * @Description: 关闭采集
        * @Author:      TJX
         * @param
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-05-15 22:37
        */
        return schedulerService.stop();
    }
}
