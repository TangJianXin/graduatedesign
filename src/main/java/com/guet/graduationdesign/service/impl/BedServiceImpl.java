package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.repository.BedRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.OldPeopleRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.BedService;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* @Description:    床位管理service
* @Author:         TJX
* @CreateDate:     2019-04-24 19:18
* @UpdateUser:
* @UpdateDate:     2019-04-24 19:18
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private OldPeopleRepository oldPeopleRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Result findById(String bedId)throws MyException {
        /**
        * @Description: 根据Id查询床位
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:36
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,bedRepository.getOne(bedId));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAll()throws MyException {
        /**
        * @Description: 查询所有床位
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:36
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,bedRepository.findAll());
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result deleteById(String bedId)throws MyException {
        /**
        * @Description: 根据Id删除床位
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:36
        */
        try{
            bedRepository.deleteById(bedId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result update(String bedId, Integer oldPeopleId, Integer employerId)throws MyException {
        /**
        * @Description: 修改床位信息
        * @Author:      TJX
         * @param bedId
         * @param oldPeopleId
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:37
        */
        try{
            Bed bed = getBed(bedId,oldPeopleId,employerId);
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,bedRepository.save(bed));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String bedId) throws MyException{
        /**
        * @Description: 添加床位
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:37
        */
        Bed bed = getBed(bedId);
        try{
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,bedRepository.save(bed));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    @Transactional
    @Override
    public Result setAdminEmployer(String bedId, Integer employerId)throws MyException {
        /**
        * @Description: 设置床位管理员
        * @Author:      TJX
         * @param bedId
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:37
        */
        try{
            Bed bed = bedRepository.getOne(bedId);
            bed.setEmployerByEmployerId(employerRepository.getOne(employerId));
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,bedRepository.save(bed));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result setUserOldPeople(String bedId, Integer oldPeopleId)throws MyException {
        /**
        * @Description: 设置床位使用老人
        * @Author:      TJX
         * @param bedId
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:37
        */
        try{
            Bed bed = bedRepository.getOne(bedId);
            bed.setOldPeopleByOldPeopleId(oldPeopleRepository.getOne(oldPeopleId));
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,bedRepository.save(bed));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    private Bed getBed(String bedId)
    {
        /**
        * @Description: 构造床位对象
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-27 20:49
        */
        Bed bed = new Bed();
        bed.setBedId(bedId);
        return bed;
    }
    private Bed getBed(String bedId,Integer oldPeopleId,Integer employerId)
    {
        /**
        * @Description: 构造床位对象
        * @Author:      TJX
         * @param bedId
         * @param oldPeopleId
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-24 21:06
        */
        Bed bed = new Bed();
        bed.setBedId(bedId);
        bed.setEmployerByEmployerId(employerRepository.getOne(employerId));
        bed.setOldPeopleByOldPeopleId(oldPeopleRepository.getOne(oldPeopleId));
        return bed;
    }
}
