package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Department;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.repository.DepartmentRepository;
import com.guet.graduationdesign.repository.EmployerRepository;
import com.guet.graduationdesign.repository.EquipmentRepository;
import com.guet.graduationdesign.result.DepartmentResult;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.DepartmentService;
import com.guet.graduationdesign.util.ResultUtil;
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
    public Result findById(String departmentId) throws MyException {
        /**
        * @Description: 根据Id查询部门
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:38
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,departmentRepository.getOne(departmentId));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAll() throws MyException{
        /**
        * @Description: 查询所有部门
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:38
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,departmentRepository.findAll());
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result deleteById(String departmentId)throws MyException {
        /**
        * @Description: 根据Id删除部门
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:38
        */
        try{
            departmentRepository.deleteById(departmentId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result update(String departmentId, String departmentName)throws MyException {
        /**
        * @Description: 更新部门信息
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:38
        */
        Department department = getDepartment(departmentId,departmentName);
        try{
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,departmentRepository.save(department));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String departmentId, String departmentName)throws MyException {
        /**
        * @Description: 添加部门
        * @Author:      TJX
         * @param departmentId
         * @param departmentName
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:38
        */
        Department department = getDepartment(departmentId,departmentName);
        try{
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,departmentRepository.save(department));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    @Override
    public Result findAllEmployer(String departmemtId)throws MyException {
        /**
        * @Description: 根据Id查询部门所有员工
        * @Author:      TJX
         * @param departmemtId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:39
        */
        try{
            List<Employer> list = employerRepository.findAll();
            List<Employer> arrayList = new ArrayList<>();
            for(Employer employer:list)
            {
                if(employer.getDepartmentByDepartmentId().getDepartmentId().equals(departmemtId))
                {
                    arrayList.add(employer);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,arrayList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAllEquipment(String departmentId)throws MyException {
        /**
        * @Description: 根据Id查询部门所有设备
        * @Author:      TJX
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:39
        */
        try{
            List<Equipment> list = equipmentRepository.findAll();
            List<Equipment> arrayList = new ArrayList<>();
            for(Equipment equipment:list)
            {
                if(equipment.getDepartmentByDepartmentId().getDepartmentId().equals(departmentId))
                {
                    arrayList.add(equipment);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,arrayList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAllPeopleAndEquipment() throws MyException {
        /**
        * @Description:
        * @Author:      TJX
         * @param 
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception   
        * @Date        2019-05-30 18:14
        */
        try{
            List<Department> departmentList = departmentRepository.findAll();
            List<Employer> employerList = employerRepository.findAll();
            List<Equipment> equipmentList = equipmentRepository.findAll();
            List<DepartmentResult> resultList = new ArrayList<>();
            int peopleCount;
            int equipmentCount;
            for(Department department:departmentList)
            {
                peopleCount = 0;
                equipmentCount = 0;
                for(Employer employer:employerList)
                {
                    if(employer.getDepartmentByDepartmentId().getDepartmentId().equals(department.getDepartmentId()))
                    {
                        peopleCount++;
                    }
                }
                for(Equipment equipment:equipmentList)
                {
                    if(equipment.getDepartmentByDepartmentId().getDepartmentId().equals(department.getDepartmentId()))
                    {
                        equipmentCount++;
                    }
                }
                DepartmentResult departmentResult = new DepartmentResult();
                departmentResult.setPeopleCount(peopleCount);
                departmentResult.setEquipmentCount(equipmentCount);
                resultList.add(departmentResult);
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,resultList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
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
