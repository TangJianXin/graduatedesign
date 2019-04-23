package com.guet.graduationdesign.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Department {
    private String departmentId;
    private String departmentName;
    private Collection<Employer> employersByDepartmentId;
    private Collection<Equipment> equipmentByDepartmentId;

    @Id
    @Column(name = "department_id")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName);
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<Employer> getEmployersByDepartmentId() {
        return employersByDepartmentId;
    }

    public void setEmployersByDepartmentId(Collection<Employer> employersByDepartmentId) {
        this.employersByDepartmentId = employersByDepartmentId;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<Equipment> getEquipmentByDepartmentId() {
        return equipmentByDepartmentId;
    }

    public void setEquipmentByDepartmentId(Collection<Equipment> equipmentByDepartmentId) {
        this.equipmentByDepartmentId = equipmentByDepartmentId;
    }
}
