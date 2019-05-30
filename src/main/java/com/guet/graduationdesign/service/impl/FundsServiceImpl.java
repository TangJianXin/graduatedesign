package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Funds;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.FundsRepository;
import com.guet.graduationdesign.result.FundsTypeResult;
import com.guet.graduationdesign.result.MoneyResult;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.FundsService;
import com.guet.graduationdesign.util.DateUtil;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
* @Description:    资金流水service
* @Author:         TJX
* @CreateDate:     2019-05-13 19:58
* @UpdateUser:
* @UpdateDate:     2019-05-13 19:58
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class FundsServiceImpl implements FundsService {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private FundsRepository fundsRepository;

    @Override
    public Result findAll() throws MyException {
        /**
        * @Description: 查询所有资金流水
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:01
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,fundsRepository.findAll());
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findByDate(String begin, String end)throws MyException {
        /**
        * @Description: 查询一段时间内所有资金流水
        * @Author:      TJX
         * @param begin
         * @param end
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:12
        */
        try{
            Date beginDate = DateUtil.getDate(begin);
            Date endDate = DateUtil.getDate(end);
            List<Funds> fundsList = fundsRepository.findAll();
            List<Funds> resultList = new ArrayList<>();
            for(Funds funds:fundsList)
            {
                if((funds.getDate().compareTo(beginDate)>0)&&(funds.getDate().compareTo(endDate)<0))
                {
                    resultList.add(funds);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result deleteById(Integer fundsId)throws MyException {
        /**
        * @Description: 根据流水号删除流水记录
        * @Author:      TJX
         * @param fundsId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:05
        */
        try{
            fundsRepository.deleteById(fundsId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Override
    public Result getWeekMoney()throws MyException {
        /**
        * @Description: 获取一周的资金情况
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-15 09:46
        */
        try
        {
            List<Funds> list = fundsRepository.findAll();
            List<MoneyResult> resultList = new ArrayList<>();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            //过去七天
            c.setTime(new Date());
            c.add(Calendar.DATE, - 6);
            for(int i=0;i<7;i++)
            {
                MoneyResult moneyResult = new MoneyResult();
                moneyResult.setDate(format.format(c.getTime()));
                c.add(Calendar.DATE,+1);
                resultList.add(moneyResult);
            }
            float income ;
            float outlay ;
            float profit ;
            for(MoneyResult moneyResult:resultList)
            {
                income = 0;
                outlay = 0;
                profit = 0;
                for(Funds funds:list)
                {
                    if(moneyResult.getDate().equals(format.format(funds.getDate())))
                    {
                        if(funds.getFlag()==1) {
                            income = income + funds.getAmount();
                        }
                        else{
                            outlay = outlay + funds.getAmount();
                        }
                    }
                }
                profit = income-outlay;
                moneyResult.setIncome(income);
                moneyResult.setOutlay(outlay);
                moneyResult.setProfit(profit);
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result add(Float amount, Integer employerId,
                      Integer flag, String detail)throws MyException {
        /**
        * @Description:  添加一条流水记录
        * @Author:      TJX
         * @param amount
         * @param employerId
         * @param flag
         * @param explain
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 20:10
        */
        try{
            Funds funds = getFunds(amount,employerId,flag,detail);
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,fundsRepository.save(funds));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    @Override
    public Result findFundsType()throws MyException {
        /**
        * @Description: 查询每天的资金类型
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-30 20:02
        */
        try{
            List<Funds> list = fundsRepository.findAll();
            List<FundsTypeResult> resultList = new ArrayList<>();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            //过去七天
            c.setTime(new Date());
            c.add(Calendar.DATE, - 6);
            for(int i=0;i<7;i++)
            {
                FundsTypeResult fundsTypeResult = new FundsTypeResult();
                fundsTypeResult.setDate(format.format(c.getTime()));
                c.add(Calendar.DATE,+1);
                resultList.add(fundsTypeResult);
            }
            float purchase;
            float pay;
            float due;
            float fix;
            float other;
            for(FundsTypeResult fundsTypeResult:resultList) {
                purchase = 0;
                pay = 0;
                due = 0;
                fix = 0;
                other = 0;
                for (Funds funds : list) {
                    if(fundsTypeResult.getDate().equals(format.format(funds.getDate())))
                    {
                        if (funds.getDetail().equals("采购")) {
                            purchase = purchase + funds.getAmount();
                        } else if (funds.getDetail().equals("工资")) {
                            pay = pay + funds.getAmount();
                        } else if (funds.getDetail().equals("月费")) {
                            due = due + funds.getAmount();
                        } else if (funds.getDetail().equals("设备维护")) {
                            fix = fix + funds.getAmount();
                        } else if (funds.getDetail().equals("其它")) {
                            other = other + funds.getAmount();
                        }
                    }
                }
                fundsTypeResult.setPurchase(purchase);
                fundsTypeResult.setPay(pay);
                fundsTypeResult.setDue(due);
                fundsTypeResult.setFix(fix);
                fundsTypeResult.setOther(other);
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }


    public Funds getFunds(Float amount, Integer employerId, Integer flag, String detail)
    {
        /**
        * @Description:  构造流水对象
        * @Author:      TJX
         * @param amount
         * @param employerId
         * @param flag
         * @param explain
        * @Return      com.guet.graduationdesign.pojo.Funds
        * @Exception
        * @Date        2019-05-13 20:08
        */
        Funds funds = new Funds();
        funds.setDate(new Date());
        funds.setAmount(amount);
        funds.setEmployerByOperator(employerRepository.getOne(employerId));
        funds.setDetail(detail);
        funds.setFlag(flag);
        return funds;
    }
}
