package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.repository.*;
import com.guet.graduationdesign.service.EmployerService;
import com.guet.graduationdesign.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @Description:    员工管理service
* @Author:         TJX
* @CreateDate:     2019-04-24 19:39
* @UpdateUser:
* @UpdateDate:     2019-04-24 19:39
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private BedRepository bedRepository;


    @Override
    public Employer findById(Integer employerId) {
        /**
        * @Description: 根据Id查询员工信息
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-24 19:40
        */
        return employerRepository.getOne(employerId);
    }

    @Override
    public List<Employer> findAll() {
        /**
        * @Description: 查询所有员工
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Employer>
        * @Exception
        * @Date        2019-04-24 19:41
        */
        return employerRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Integer employerId) {
        /**
        * @Description: 根据Id删除员工信息
        * @Author:      TJX
         * @param employerId
        * @Return      void
        * @Exception
        * @Date        2019-04-24 19:42
        */
        employerRepository.deleteById(employerId);
    }

    @Transactional
    @Override
    public Employer update(Integer employerId, String position, String name, String telephone, String address, String idCard, String birthday, String photo, String sex, String departmentId) {
        /**
        * @Description: 修改员工信息
        * @Author:      TJX
         * @param employerId
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-24 21:28
        */
        Employer employer =  getEmployer(employerId,position,name,telephone,address,idCard, DateUtil.getDate(birthday),photo,sex,departmentId);
        return employerRepository.save(employer);
    }

    @Transactional
    @Override
    public Employer add(String position, String name, String telephone, String address, String idCard, String birthday, String photo, String sex, String departmentId,String entryDate) {
        /**
        * @Description: 添加员工
        * @Author:      TJX
         * @param employerId
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-24 21:28
        */

        Employer employer = getEmployer(position,name,telephone,address,idCard,DateUtil.getDate(birthday),photo,sex,departmentId,DateUtil.getDate(entryDate));
        employerRepository.save(employer);
        List<Employer> list = findAll();
        return list.get(list.size()-1);
    }

    @Override
    public List<Bed> findAllBedById(Integer employerId) {
        /**
        * @Description: 根据员工Id查询所有管理的床位
        * @Author:      TJX
         * @param employerId
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Bed>
        * @Exception
        * @Date        2019-04-27 20:22
        */
        List<Bed> list = bedRepository.findAll();
        List<Bed> arrayList = new ArrayList<>();
        for(Bed bed:list)
        {
            if(bed.getEmployerByEmployerId().getEmployerId()==employerId)
            {
                arrayList.add(bed);
            }
        }
        return arrayList;
    }

    private Employer getEmployer(String position, String name,
                                 String telephone, String address, String idCard,
                                 Date birthday, String photo, String sex, String departmentId,Date entryDate)
    {
        /**
        * @Description: 构造员工对象
        * @Author:      TJX
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-24 21:26
        */
        Employer employer = new Employer();
        employer.setAddress(address);
        employer.setBirthday(birthday);
        employer.setName(name);
        employer.setPhoto(photo);
        employer.setPosition(position);
        employer.setSex(sex);
        employer.setDepartmentByDepartmentId(departmentRepository.getOne(departmentId));
        employer.setTelephone(telephone);
        employer.setIdCard(idCard);
        employer.setEntryDate(entryDate);
        return employer;
    }
    private Employer getEmployer(Integer employerId,String position, String name,
                                 String telephone, String address, String idCard,
                                 Date birthday, String photo, String sex, String departmentId)
    {
        /**
        * @Description: 构造员工对象
        * @Author:      TJX
         * @param employerId
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-04-26 10:52
        */
        Employer employer = new Employer();
        employer.setEmployerId(employerId);
        employer.setAddress(address);
        employer.setBirthday(birthday);
        employer.setName(name);
        employer.setPhoto(photo);
        employer.setPosition(position);
        employer.setSex(sex);
        employer.setDepartmentByDepartmentId(departmentRepository.getOne(departmentId));
        employer.setTelephone(telephone);
        employer.setIdCard(idCard);
        return employer;
    }
}
