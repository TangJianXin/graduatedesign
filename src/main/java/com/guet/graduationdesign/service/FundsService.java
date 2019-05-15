package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;

public interface FundsService {

    //查询所有资金流水
    public Result findAll();

    //根据时间段查询流水
    public Result findByDate(String begin,String end);

    //根据流水号删除资金流水记录
    public Result deleteById(Integer fundsId);

    //获取一周的资金情况
    public Result getWeekMoney();

    //添加一条流水记录
    public Result add(Float amount,Integer employerId,Integer flag,String detail);

}
