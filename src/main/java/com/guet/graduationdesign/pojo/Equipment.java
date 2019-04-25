package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
public class Equipment {
    private String equipmentId;
    private String equipmentName;
    private Date purchaseDate;
    private Date productionDate;
    private Department departmentByDepartmentId;

    @Id
    @Column(name = "equipment_id")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "equipment_name")
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Basic
    @Column(name = "purchase_date")
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "production_date")
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(equipmentId, equipment.equipmentId) &&
                Objects.equals(equipmentName, equipment.equipmentName) &&
                Objects.equals(purchaseDate, equipment.purchaseDate) &&
                Objects.equals(productionDate, equipment.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, equipmentName, purchaseDate, productionDate);
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId='" + equipmentId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", productionDate=" + productionDate +
                ", departmentByDepartmentId=" + departmentByDepartmentId +
                '}';
    }
}
