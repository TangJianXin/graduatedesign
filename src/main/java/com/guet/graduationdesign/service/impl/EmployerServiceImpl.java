package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Bed;
import com.guet.graduationdesign.pojo.Employer;
import com.guet.graduationdesign.repository.*;
import com.guet.graduationdesign.result.EmployerResult;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.EmployerService;
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
    public Result findById(Integer employerId) throws MyException {
        /**
        * @Description: 根据Id查询员工
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:40
        */
        try{
            Employer employer = employerRepository.getOne(employerId);
            EmployerResult employerResult = new EmployerResult();
            employerResult.setEmployer(employer);
            employerResult.setUrl(MultipartFileUtil.getFile(employer.getPhoto()));
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,employerResult);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAll()throws MyException {
        /**
        * @Description: 查询所有员工
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:40
        */
        try{
            List<Employer> list = employerRepository.findAll();
            List<EmployerResult> arrayList = new ArrayList<>();
            for(Employer employer:list)
            {
                EmployerResult employerResult = new EmployerResult();
                employerResult.setEmployer(employer);
                employerResult.setUrl(MultipartFileUtil.getFile(employer.getPhoto()));
                arrayList.add(employerResult);
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,arrayList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result deleteById(Integer employerId)throws MyException {
        /**
        * @Description: 根据Id删除员工
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:40
        */
        try{
            employerRepository.deleteById(employerId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result update(Integer employerId, String position, String name, String telephone, String address,
                         String idCard, String birthday, String photo, String sex, String departmentId,
                         String entryDate) throws MyException{
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
         * @param entryDate
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-06 00:34
        */
        try{
            Employer employer =  getEmployer(employerId,position,name,telephone,address,idCard, DateUtil.getDate(birthday),photo,sex,departmentId,DateUtil.getDate(entryDate));
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,employerRepository.save(employer));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String position, String name, String telephone,
                      String address, String idCard, String birthday,
                      String photo, String sex, String departmentId,String entryDate) throws MyException{
        /**
        * @Description: 添加员工
        * @Author:      TJX
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
         * @param entryDate
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:41
        */
        try{
            Employer employer = getEmployer(position,name,telephone,address,idCard,DateUtil.getDate(birthday),photo,sex,departmentId,DateUtil.getDate(entryDate));
            employerRepository.save(employer);
            List<Employer> list = employerRepository.findAll();
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,list.get(list.size()-1));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    @Override
    public Result findAllBedById(Integer employerId) throws MyException{
        /**
        * @Description: 根据Id查找员工管理的床位
        * @Author:      TJX
         * @param employerId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:41
        */
        try{
            List<Bed> list = bedRepository.findAll();
            List<Bed> arrayList = new ArrayList<>();
            for(Bed bed:list)
            {
                if(bed.getEmployerByEmployerId().getEmployerId()==employerId)
                {
                    arrayList.add(bed);
                }
            }
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,arrayList);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    private Employer getEmployer(String position, String name,
                                 String telephone, String address, String idCard,
                                 Date birthday, String photo, String sex, String departmentId,Date entryDate)
    {
        /**
        * @Description: 构造员工对象
        * @Author:      TJX
         * @param position
         * @param name
         * @param telephone
         * @param address
         * @param idCard
         * @param birthday
         * @param photo
         * @param sex
         * @param departmentId
         * @param entryDate
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-05-06 00:34
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
                                 Date birthday, String photo, String sex, String departmentId,
                                 Date entryDate)
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
         * @param entryDate
        * @Return      com.guet.graduationdesign.pojo.Employer
        * @Exception
        * @Date        2019-05-06 00:33
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
        employer.setEntryDate(entryDate);
        return employer;
    }
}
