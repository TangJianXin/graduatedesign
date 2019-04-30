package com.guet.graduationdesign.service;

import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.pojo.Employer;
import java.util.List;


public interface EmployerService {

    //根据Id查询员工
    public Employer findById(Integer employerId);

    //查询所有员工
    public List<Employer> findAll();

    //根据Id删除员工
    public void deleteById(Integer employerId);

    //更新员工
    public Employer update(Integer employerId, String position, String name,
                           String telephone, String address, String idCard,
                           String birthday, String photo, String sex, String departmentId);

    //添加员工
    public Employer add(String position, String name,
                        String telephone, String address, String idCard,
                        String birthday, String photo, String sex, String departmentId,
                        String entryDate);

    //根据员工Id查询员工管理的床位
    public List<Bed> findAllBedById(Integer employerId);

}
