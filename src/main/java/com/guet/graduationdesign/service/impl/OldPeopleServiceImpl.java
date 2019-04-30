package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.OldPeople;
import com.guet.graduationdesign.repository.BedRepository;
import com.guet.graduationdesign.repository.OldPeopleRepository;
import com.guet.graduationdesign.service.OldPeopleService;
import com.guet.graduationdesign.util.DateUtil;
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
    public OldPeople findById(Integer oldPeopleId) {
        /**
        * @Description: 根据Id查询老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-24 19:58
        */
        return oldPeopleRepository.getOne(oldPeopleId);
    }

    @Override
    public List<OldPeople> findAll() {
        /**
        * @Description: 查询所有老人
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.OldPeople>
        * @Exception
        * @Date        2019-04-24 19:59
        */
        return oldPeopleRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Integer oldPeopleId) {
        /**
        * @Description: 根据Id删除老人信息
        * @Author:      TJX
         * @param oldPeopleId
        * @Return      void
        * @Exception
        * @Date        2019-04-24 19:59
        */
        oldPeopleRepository.deleteById(oldPeopleId);
    }

    @Transactional
    @Override
    public OldPeople update(Integer oldPeopleId, String idCard, String photo, String name, String telephone, String address, String sex, String birthday, String familyPhone) {
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
        * @Return      com.guet.graduationdesign.pojo.OldPeople
        * @Exception
        * @Date        2019-04-24 21:56
        */
        OldPeople oldPeople = getOldPeople(oldPeopleId,idCard,photo,name,telephone,address,sex,DateUtil.getDate(birthday),familyPhone);
        return oldPeopleRepository.save(oldPeople);
    }

    @Transactional
    @Override
    public OldPeople add(String idCard, String photo, String name, String telephone, String address, String sex, String birthday, String familyPhone,String entryDate) {
        /**
        * @Description: 添加老人
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
        * @Date        2019-04-24 21:55
        */
        OldPeople oldPeople = getOldPeople(idCard,photo,name,telephone,address,sex, DateUtil.getDate(birthday),familyPhone,DateUtil.getDate(entryDate));
        oldPeopleRepository.save(oldPeople);
        List<OldPeople> list = findAll();
        return list.get(list.size()-1);
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
