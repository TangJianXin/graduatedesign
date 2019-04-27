package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Department;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.repository.DepartmentRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.EquipmentRepository;
import com.guet.graduationdesign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:    部门管理service
* @Author:         TJX
* @CreateDate:     2019-04-24 19:28
* @UpdateUser:
* @UpdateDate:     2019-04-24 19:28
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Department findById(String departmentId) {
        /**
        * @Description: 根据Id查询部门
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-24 19:37
        */
        return departmentRepository.getOne(departmentId);
    }

    @Override
    public List<Department> findAll() {
        /**
        * @Description: 查询所有部门
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Department>
        * @Exception
        * @Date        2019-04-24 19:37
        */
        return departmentRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(String departmentId) {
        /**
        * @Description: 根据Id删除部门
        * @Author:      TJX
         * @param departmentId
        * @Return      void
        * @Exception
        * @Date        2019-04-24 19:37
        */
        departmentRepository.deleteById(departmentId);
    }

    @Transactional
    @Override
    public Department update(String departmentId, String departmentName) {
        /**
        * @Description: 更新部门信息
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-24 21:16
        */
        return add(departmentId,departmentName);
    }

    @Transactional
    @Override
    public Department add(String departmentId, String departmentName) {
        /**
        * @Description: 添加部门
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-24 21:16
        */
        Department department = getDepartment(departmentId,departmentName);
        return departmentRepository.save(department);
    }

    @Override
    public List<Employer> findAllEmployer(String departmemtId) {
        /**
        * @Description: 查询部门所属员工
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Employer>
        * @Exception
        * @Date        2019-04-27 16:34
        */
        List<Employer> list = employerRepository.findAll();
        List<Employer> arrayList = new ArrayList<>();
        for(Employer employer:list)
        {
            if(employer.getDepartmentByDepartmentId().getDepartmentId().equals(departmemtId))
            {
                arrayList.add(employer);
            }
        }
        return arrayList;
    }

    @Override
    public List<Equipment> findAllEquipment(String departmentId) {
        /**
        * @Description: 查询部门所有设备
        * @Author:      TJX
         * @param departmentId
        * @Return      java.util.ArrayList<com.guet.graduationdesign.pojo.Equipment>
        * @Exception
        * @Date        2019-04-27 16:42
        */
        List<Equipment> list = equipmentRepository.findAll();
        List<Equipment> arrayList = new ArrayList<>();
        for(Equipment equipment:list)
        {
            if(equipment.getDepartmentByDepartmentId().getDepartmentId().equals(departmentId))
            {
                arrayList.add(equipment);
            }
        }
        return arrayList;
    }

    private Department getDepartment(String departmentId,String departmentName)
    {
        /**
        * @Description: 构造部门对象
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.pojo.Department
        * @Exception
        * @Date        2019-04-24 21:14
        */
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        return department;
    }
}
