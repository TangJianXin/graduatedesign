package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Quota;
import com.guet.graduationdesign.repository.BedRepository;
import com.guet.graduationdesign.repository.OldPeopleRepository;
import com.guet.graduationdesign.repository.QuotaRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.QuotaService;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @Description:    体征指标service
* @Author:         TJX
* @CreateDate:     2019-05-13 19:01
* @UpdateUser:
* @UpdateDate:     2019-05-13 19:01
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class QuotaServiceImpl implements QuotaService {

    @Autowired
    private QuotaRepository quotaRepository;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private OldPeopleRepository oldPeopleRepository;

    @Override
    public Result findAll()throws MyException {
        /**
        * @Description: 查询所有体征指标
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 18:46
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,quotaRepository.findAll());
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findByName(String name)throws MyException {
        /**
        * @Description: 根据老人姓名查询体征指标
        * @Author:      TJX
         * @param name
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 18:48
        */
        try{
            List<Quota> quotaList = quotaRepository.findAll();
            List<Quota> resultList = new ArrayList<>();
            for(Quota quota:quotaList)
            {
                if(quota.getOldPeopleByOldpeople().getName().equals(name))
                {
                    resultList.add(quota);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result deleteById(Integer quotaId)throws MyException {
        /**
        * @Description: 根据体征Id删除体征记录
        * @Author:      TJX
         * @param quotaId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 18:52
        */
        try{
            quotaRepository.deleteById(quotaId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Override
    public Result add(Integer heartRate, Integer breatheRate, Float temperature,
                      Integer oldPeopleId, String bedId)throws MyException {
        /**
        * @Description: 添加一条体征记录
        * @Author:      TJX
         * @param heartRate
         * @param breatheRate
         * @param temperature
         * @param oldPeopleId
         * @param bedId
         * @param date
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-13 18:54
        */
        try{
            Quota quota = getQuota(heartRate,breatheRate,temperature,oldPeopleId,bedId);
            quota.setDate(new Date());
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,quotaRepository.save(quota));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    public Quota getQuota(Integer heartRate, Integer breatheRate, Float temperature, Integer oldPeopleId, String bedId)
    {
        /**
        * @Description: 构造体征记录对象
        * @Author:      TJX
         * @param heartRate
         * @param breatheRate
         * @param temperature
         * @param oldPeopleId
         * @param bedId
         * @param date
        * @Return      com.guet.graduationdesign.pojo.Quota
        * @Exception
        * @Date        2019-05-13 18:57
        */
        Quota quota = new Quota();
        quota.setHeartRate(heartRate);
        quota.setBreatheRate(breatheRate);
        quota.setTemperature(temperature);
        quota.setOldPeopleByOldpeople(oldPeopleRepository.getOne(oldPeopleId));
        quota.setBedByBed(bedRepository.getOne(bedId));
        return quota;
    }
}
