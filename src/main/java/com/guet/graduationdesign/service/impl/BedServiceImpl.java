package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.pojo.OldPeople;
import com.guet.graduationdesign.repository.BedRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.OldPeopleRepository;
import com.guet.graduationdesign.service.BedService;
import java.util.List;
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
    public Bed findById(String bedId) {
        /**
        * @Description: 根据Id查询床位
        * @Author:      TJX
         * @param bedId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-24 19:18
        */
        return bedRepository.getOne(bedId);
    }

    @Override
    public List<Bed> findAll() {
        /**
        * @Description: 查询所有床位
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Bed>
        * @Exception
        * @Date        2019-04-24 19:19
        */
        return bedRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(String bedId) {
        /**
        * @Description: 根据Id删除床位
        * @Author:      TJX
         * @param bedId
        * @Return      void
        * @Exception
        * @Date        2019-04-24 19:19
        */
        bedRepository.deleteById(bedId);
    }

    @Transactional
    @Override
    public Bed update(String bedId, Integer oldPeopleId, Integer employerId) {
        /**
        * @Description:  修改床位信息
        * @Author:      TJX
         * @param bedId
         * @param oldPeopleId
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-24 21:10
        */
        Bed bed = getBed(bedId,oldPeopleId,employerId);
        return bedRepository.save(bed);
    }

    @Transactional
    @Override
    public Bed add(String bedId) {
        /**
        * @Description: 添加床位
        * @Author:      TJX
         * @param bedId
         * @param oldPeopleId
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-24 21:09
        */
        Bed bed = getBed(bedId);
        return bedRepository.save(bed);
    }

    @Transactional
    @Override
    public Bed setAdminEmployer(String bedId, Integer employerId) {
        /**
        * @Description: 设置床位管理人员
        * @Author:      TJX
         * @param bedId
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-27 20:52
        */
        Bed bed = findById(bedId);
        bed.setEmployerByEmployerId(employerRepository.getOne(employerId));
        bedRepository.save(bed);
        return bed;
    }

    @Transactional
    @Override
    public Bed setUserOldPeople(String bedId, Integer oldPeopleId) {
        /**
        * @Description: 设置床位使用老人
        * @Author:      TJX
         * @param bedId
         * @param oldPeopleId
        * @Return      com.guet.graduationdesign.pojo.Bed
        * @Exception
        * @Date        2019-04-27 20:52
        */
        Bed bed = findById(bedId);
        OldPeople oldPeople = oldPeopleRepository.getOne(oldPeopleId);
        bed.setOldPeopleByOldPeopleId(oldPeople);
        bedRepository.save(bed);
        return bed;
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
