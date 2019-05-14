package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.pojo.OldPeople;
import com.guet.graduationdesign.repository.BedRepository;
import com.guet.graduationdesign.repository.OldPeopleRepository;
import com.guet.graduationdesign.result.OldPeopleResult;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.OldPeopleService;
import com.guet.graduationdesign.util.DateUtil;
import com.guet.graduationdesign.util.MultipartFileUtil;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
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

    @Autowired
    private BedRepository bedRepository;

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
            OldPeople oldPeople = oldPeopleRepository.getOne(oldPeopleId);
            OldPeopleResult oldPeopleResult = new OldPeopleResult();
            oldPeopleResult.setOldPeople(oldPeople);
            oldPeopleResult.setUrl(MultipartFileUtil.getFile(oldPeople.getPhoto()));
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,oldPeopleResult);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findByName(String name)throws MyException {
        /**
        * @Description: 根据姓名查询老人
        * @Author:      TJX
         * @param name
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-14 10:49
        */
        try{
            List<OldPeople> list = oldPeopleRepository.findAll();
            List<OldPeopleResult> resultList = new ArrayList<>();
            for(OldPeople oldPeople:list)
            {
                if(oldPeople.getName().equals(name))
                {
                    OldPeopleResult oldPeopleResult = new OldPeopleResult();
                    oldPeopleResult.setOldPeople(oldPeople);
                    oldPeopleResult.setUrl(MultipartFileUtil.getFile(oldPeople.getPhoto()));
                    resultList.add(oldPeopleResult);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
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
            List<OldPeople> list = oldPeopleRepository.findAll();
            List<OldPeopleResult> arrayList = new ArrayList<>();
            for(OldPeople oldPeople:list)
            {
                OldPeopleResult oldPeopleResult = new OldPeopleResult();
                oldPeopleResult.setOldPeople(oldPeople);
                oldPeopleResult.setUrl(MultipartFileUtil.getFile(oldPeople.getPhoto()));
                arrayList.add(oldPeopleResult);
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,arrayList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAllEmpty()throws MyException {
        /**
        * @Description: 查询所有未安排床位的老人
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-07 17:40
        */
        try{
            List<Bed> bedList = bedRepository.findAll();
            List<OldPeople> oldPeopleList = oldPeopleRepository.findAll();
            List<OldPeople> resultList = new ArrayList<>();
            boolean flag;
            for(OldPeople oldPeople :oldPeopleList)
            {
                flag = true;
                for(Bed bed:bedList)
                {
                    if(bed.getOldPeopleByOldPeopleId()==null)
                    {
                        continue;
                    }
                    if(oldPeople.getOldPeopleId()==bed.getOldPeopleByOldPeopleId().getOldPeopleId())
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    resultList.add(oldPeople);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
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
                         String sex, String birthday, String familyPhone,String entryDate)throws MyException {
        /**
        * @Description: 更新老人信息
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
         * @param entryDate
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-06 00:33
        */
        OldPeople oldPeople = getOldPeople(oldPeopleId,idCard,photo,name,telephone,address,sex,DateUtil.getDate(birthday),familyPhone,DateUtil.getDate(entryDate));
        try{
            oldPeopleRepository.save(oldPeople);
            oldPeople.setPhoto(MultipartFileUtil.getFile(oldPeople.getPhoto()));
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,oldPeople);
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

    @Override
    public Result getAge()throws MyException {
        /**
        * @Description: 获取老人年龄分布
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-14 20:31
        */
        try{
            List<OldPeople> list = oldPeopleRepository.findAll();
            List<Integer> resultList = new ArrayList<>();
            int age;
            int A = 0;
            int B = 0;
            int C = 0;
            int D = 0;
            int E = 0;
            for(OldPeople oldPeople:list)
            {
                age = 2019-(1900+oldPeople.getBirthday().getYear());
                if(age>=50&&age<55)
                {
                    A++;
                }
                else if(age>=55&&age<60)
                {
                    B++;
                }
                else if(age>=60&&age<65)
                {
                    C++;
                }
                else if(age>=65&&age<70)
                {
                    D++;
                }
                else if(age>=70)
                {
                    E++;
                }
            }
            resultList.add(A);
            resultList.add(B);
            resultList.add(C);
            resultList.add(D);
            resultList.add(E);
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    private OldPeople getOldPeople(Integer oldPeopleId, String idCard, String photo,
                                   String name, String telephone, String address,
                                   String sex, Date birthday,String familyPhone,Date entryDate)
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
         * @param entryDate
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-05-06 00:33
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
        oldPeople.setEntryDate(entryDate);
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
