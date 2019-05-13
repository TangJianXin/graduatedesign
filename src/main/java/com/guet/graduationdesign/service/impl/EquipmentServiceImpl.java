package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.repository.DepartmentRepository;
import com.guet.graduationdesign.repository.EquipmentRepository;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.EquipmentService;
import com.guet.graduationdesign.util.DateUtil;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
* @Description:    设备管理service
* @Author:         TJX
* @CreateDate:     2019-04-24 19:43
* @UpdateUser:
* @UpdateDate:     2019-04-24 19:43
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Result findById(Integer equipmentId) throws MyException {
        /**
        * @Description: 根据Id查询设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:41
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,equipmentRepository.getOne(equipmentId));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Override
    public Result findAll()throws MyException {
        /**
        * @Description: 查询所有设备
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:42
        */
        try{
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS,equipmentRepository.findAll());
        }catch (Exception e)
        {
          throw new MyException(ResultEnum.SELETCT_FAIL);
        }
    }

    @Transactional
    @Override
    public Result deleteById(Integer equipmentId)throws MyException {
        /**
        * @Description: 查询所有设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:42
        */
        try {
            equipmentRepository.deleteById(equipmentId);
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.DELETE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result update(Integer equipmentId, String equipmentName,
                            String purchaseDate,String productionDate,
                            String departmentId)throws MyException {
        /**
        * @Description: 修改设备信息
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:42
        */
        try{
            Equipment equipment = getEquipment(equipmentId,equipmentName, DateUtil.getDate(purchaseDate),DateUtil.getDate(productionDate),departmentId);
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS,equipmentRepository.save(equipment));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.UPDATE_FAIL);
        }
    }

    @Transactional
    @Override
    public Result add(String equipmentName,
                         String purchaseDate,String productionDate,
                      String departmentId)throws MyException {
        /**
        * @Description: 添加设备
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:42
        */
        try{
            Equipment equipment = getEquipment(equipmentName, DateUtil.getDate(purchaseDate),DateUtil.getDate(productionDate),departmentId);
            return ResultUtil.success(ResultEnum.ADD_SUCCESS,equipmentRepository.save(equipment));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    private Equipment getEquipment(Integer equipmentId, String equipmentName,
                                   Date purchaseDate, Date productionDate, String departmentId)
    {
        /**
        * @Description: 构造设备对象
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-24 21:39
        */
        Equipment equipment = new Equipment();
        equipment.setEquipmentId(equipmentId);
        equipment.setEquipmentName(equipmentName);
        equipment.setPurchaseDate(purchaseDate);
        equipment.setProductionDate(productionDate);
        equipment.setDepartmentByDepartmentId(departmentRepository.getOne(departmentId));
        return equipment;
    }
    private Equipment getEquipment(String equipmentName, Date purchaseDate, Date productionDate,String departmentId)
    {
        /**
        * @Description: 构造设备对象
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-05-12 11:43
        */
        Equipment equipment = new Equipment();
        equipment.setEquipmentName(equipmentName);
        equipment.setPurchaseDate(purchaseDate);
        equipment.setProductionDate(productionDate);
        equipment.setDepartmentByDepartmentId(departmentRepository.getOne(departmentId));
        return equipment;
    }
}
