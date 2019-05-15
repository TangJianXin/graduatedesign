package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface SchedulerService {


    //开启定时任务
    public Result start(Integer oldPeopleId);

    //关闭定时任务
    public Result stop();
}

