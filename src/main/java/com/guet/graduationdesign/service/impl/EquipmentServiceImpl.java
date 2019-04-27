package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Equipment;
import com.guet.graduationdesign.repository.DepartmentRepository;
import com.guet.graduationdesign.repository.EquipmentRepository;
import com.guet.graduationdesign.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

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
    public Equipment findById(String equipmentId) {
        /**
        * @Description: 根据Id查询设备信息
        * @Author:      TJX
         * @param equipmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-24 19:45
        */
        return equipmentRepository.getOne(equipmentId);
    }

    @Override
    public List<Equipment> findAll() {
        /**
        * @Description: 查询所有设备信息
        * @Author:      TJX
         * @param
        * @Return      java.util.List<com.guet.graduationdesign.pojo.Equipment>
        * @Exception
        * @Date        2019-04-24 19:46
        */
        return equipmentRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(String equipmentId) {
        /**
        * @Description: 根据Id删除设备
        * @Author:      TJX
         * @param equipmentId
        * @Return      void
        * @Exception
        * @Date        2019-04-24 19:46
        */
        equipmentRepository.deleteById(equipmentId);
    }

    @Transactional
    @Override
    public Equipment update(String equipmentId, String equipmentName,
                            Date purchaseDate,Date productionDate,String departmentId) {
        /**
        * @Description: 修改设备信息
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-24 21:40
        */
        return add(equipmentId,equipmentName,purchaseDate,productionDate,departmentId);
    }

    @Transactional
    @Override
    public Equipment add(String equipmentId, String equipmentName,
                         Date purchaseDate,Date productionDate,String departmentId) {
        /**
        * @Description: 添加设备
        * @Author:      TJX
         * @param equipmentId
         * @param equipmentName
         * @param purchaseDate
         * @param productionDate
         * @param departmentId
        * @Return      com.guet.graduationdesign.pojo.Equipment
        * @Exception
        * @Date        2019-04-24 21:40
        */
        Equipment equipment = getEquipment(equipmentId,equipmentName,purchaseDate,productionDate,departmentId);
        return equipmentRepository.save(equipment);
    }

    private Equipment getEquipment(String equipmentId, String equipmentName,
                                   Date purchaseDate,Date productionDate,String departmentId)
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
}
