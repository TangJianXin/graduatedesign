package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.repository.DepartmentRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    @Override
    public Employer update(Integer employerId, String position, String name, String telephone, String address, String idCard, Date birthday, String photo, String sex, String departmentId) {
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
        return add(employerId,position,name,telephone,address,idCard,birthday,photo,sex,departmentId);
    }

    @Override
    public Employer add(Integer employerId, String position, String name, String telephone, String address, String idCard, Date birthday, String photo, String sex, String departmentId) {
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
        Employer employer = getEmployer(employerId,position,name,telephone,address,idCard,birthday,photo,sex,departmentId);
        return employerRepository.save(employer);
    }

    private Employer getEmployer(Integer employerId, String position, String name,
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
        * @Date        2019-04-24 21:26
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
