package com.guet.graduationdesign.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employer {
    private int employerId;
    private String position;
    private String name;
    private String telephone;
    private String address;
    private String idCard;
    private Date birthday;
    private String photo;
    private String sex;
    private Collection<Admin> adminsByEmployerId;
    private Collection<Bed> bedsByEmployerId;
    private Department departmentByDepartmentId;
    private Collection<User> usersByEmployerId;

    @Id
    @Column(name = "employer_Id")
    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return employerId == employer.employerId &&
                Objects.equals(position, employer.position) &&
                Objects.equals(name, employer.name) &&
                Objects.equals(telephone, employer.telephone) &&
                Objects.equals(address, employer.address) &&
                Objects.equals(idCard, employer.idCard) &&
                Objects.equals(birthday, employer.birthday) &&
                Objects.equals(photo, employer.photo) &&
                Objects.equals(sex, employer.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employerId, position, name, telephone, address, idCard, birthday, photo, sex);
    }

    @OneToMany(mappedBy = "employerByEmployerId")
    public Collection<Admin> getAdminsByEmployerId() {
        return adminsByEmployerId;
    }

    public void setAdminsByEmployerId(Collection<Admin> adminsByEmployerId) {
        this.adminsByEmployerId = adminsByEmployerId;
    }

    @OneToMany(mappedBy = "employerByEmployerId")
    public Collection<Bed> getBedsByEmployerId() {
        return bedsByEmployerId;
    }

    public void setBedsByEmployerId(Collection<Bed> bedsByEmployerId) {
        this.bedsByEmployerId = bedsByEmployerId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @OneToMany(mappedBy = "employerByEmployerId")
    public Collection<User> getUsersByEmployerId() {
        return usersByEmployerId;
    }

    public void setUsersByEmployerId(Collection<User> usersByEmployerId) {
        this.usersByEmployerId = usersByEmployerId;
    }
}
