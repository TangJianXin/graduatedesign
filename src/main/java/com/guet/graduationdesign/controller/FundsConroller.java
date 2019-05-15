package com.guet.graduationdesign.controller;


import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.FundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @Description:    资金流水控制器
* @Author:         TJX
* @CreateDate:     2019-05-13 20:20
* @UpdateUser:
* @UpdateDate:     2019-05-13 20:20
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/funds")
public class FundsConroller {

    @Autowired
    private FundsService fundsService;

    @GetMapping(value = "/findAll")
    public Result findAll()
    {
        /**
        * @Description:  查询所有资金流水记录
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:21
        */
         return fundsService.findAll();
    }

    @GetMapping(value = "/findByDate")
    public Result findByDate(String begin,String end)
    {
        /**
        * @Description: 查询一段时间内的资金流水
        * @Author:      TJX
         * @param begin
         * @param end
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:22
        */
        return fundsService.findByDate(begin,end);
    }

    @GetMapping(value = "/getWeekMoney")
    public Result getWeekMoney()
    {
        /**
        * @Description: 获取一周内的资金
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-15 09:52
        */
        return fundsService.getWeekMoney();
    }

    @PostMapping(value = "/deleteById")
    public Result deleteById(Integer fundsId)
    {
        /**
        * @Description: 根据流水号删除流水记录
        * @Author:      TJX
         * @param fundsId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:23
        */
        return fundsService.deleteById(fundsId);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestParam("amount") Float amount,
                      @RequestParam("employerId") Integer employerId,
                      @RequestParam("flag") Integer flag,
                      @RequestParam("detail") String detail)
    {
        /**
        * @Description: 添加一条流水记录
        * @Author:      TJX
         * @param amount
         * @param employerId
         * @param flag
         * @param explain
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:24
        */
        return fundsService.add(amount,employerId,flag,detail);
    }
}
