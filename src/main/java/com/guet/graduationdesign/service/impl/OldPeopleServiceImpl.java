package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.OldPeople;
import com.guet.graduationdesign.repository.OldPeopleRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.OldPeopleService;
import com.guet.graduationdesign.util.DateUtil;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
* @Description:    老人管理service
* @Author:         TJX
* @CreateDate:     2019-04-24 19:51
* @UpdateUser:
* @UpdateDate:     2019-04-24 19:51
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class OldPeopleServiceImpl implements OldPeopleService {

    @Autowired
    private OldPeopleRepository oldPeopleRepository;

    @Override
    public Result findById(Integer oldPeopleId)throws MyException {
        /**
        * @Description: 根据Id查询老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:43
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,oldPeopleRepository.getOne(oldPeopleId));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAll()throws MyException {
        /**
        * @Description: 查询所有老人
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:43
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,oldPeopleRepository.findAll());
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result delete(Integer oldPeopleId)throws MyException {
        /**
        * @Description: 根据Id删除老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:43
        */
        try{
            oldPeopleRepository.deleteById(oldPeopleId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result update(Integer oldPeopleId, String idCard, String photo,
                         String name, String telephone, String address,
                         String sex, String birthday, String familyPhone)throws MyException {
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
        * @Date        2019-05-02 21:44
        */
        OldPeople oldPeople = getOldPeople(oldPeopleId,idCard,photo,name,telephone,address,sex,DateUtil.getDate(birthday),familyPhone);
        try{
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,oldPeopleRepository.save(oldPeople));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String idCard, String photo, String name,
                      String telephone, String address, String sex,
                      String birthday, String familyPhone,String entryDate)throws MyException {
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
         * @param entryDate
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:44
        */
        OldPeople oldPeople = getOldPeople(idCard,photo,name,telephone,address,sex, DateUtil.getDate(birthday),familyPhone,DateUtil.getDate(entryDate));
        try{
            oldPeopleRepository.save(oldPeople);
            List<OldPeople> list = oldPeopleRepository.findAll();
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,list.get(list.size()-1));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    private OldPeople getOldPeople(Integer oldPeopleId, String idCard, String photo,
                                   String name, String telephone, String address,
                                   String sex, Date birthday,String familyPhone)
    {
        /**
        * @Description: 构造老人对象
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
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-24 21:49
        */
        OldPeople oldPeople = new OldPeople();
        oldPeople.setOldPeopleId(oldPeopleId);
        oldPeople.setIdCard(idCard);
        oldPeople.setPhoto(photo);
        oldPeople.setName(name);
        oldPeople.setTelephone(telephone);
        oldPeople.setAddress(address);
        oldPeople.setSex(sex);
        oldPeople.setBirthday(birthday);
        oldPeople.setFamilyPhone(familyPhone);
        return oldPeople;
    }

    private OldPeople getOldPeople(String idCard, String photo,
                                   String name, String telephone, String address,
                                   String sex, Date birthday, String familyPhone,
                                   Date entryDate)
    {
        /**
        * @Description: 构造老人对象
        * @Author:      TJX
         * @param idCard
         * @param photo
         * @param name
         * @param telephone
         * @param address
         * @param sex
         * @param birthday
         * @param familyPhone
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-26 16:55
        */
        OldPeople oldPeople = new OldPeople();
        oldPeople.setIdCard(idCard);
        oldPeople.setPhoto(photo);
        oldPeople.setName(name);
        oldPeople.setTelephone(telephone);
        oldPeople.setAddress(address);
        oldPeople.setSex(sex);
        oldPeople.setBirthday(birthday);
        oldPeople.setFamilyPhone(familyPhone);
        oldPeople.setEntryDate(entryDate);
        return oldPeople;
    }
}
