package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
@Table(name = "old_people", schema = "IntelligentNursingHomeManagementSystem", catalog = "")
public class OldPeople {
    private int oldPeopleId;
    private String idCard;
    private String photo;
    private String name;
    private String telephone;
    private String address;
    private String sex;
    private Date birthday;
    private String familyPhone;
    private Date entryDate;
    private Date leaveDate;

    @Id
    @Column(name = "old_people_id")
    public int getOldPeopleId() {
        return oldPeopleId;
    }

    public void setOldPeopleId(int oldPeopleId) {
        this.oldPeopleId = oldPeopleId;
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
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "family_phone")
    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    @Basic
    @Column(name = "entry_date")
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(java.sql.Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Basic
    @Column(name = "leave_date")
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(java.sql.Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldPeople oldPeople = (OldPeople) o;
        return oldPeopleId == oldPeople.oldPeopleId &&
                Objects.equals(idCard, oldPeople.idCard) &&
                Objects.equals(photo, oldPeople.photo) &&
                Objects.equals(name, oldPeople.name) &&
                Objects.equals(telephone, oldPeople.telephone) &&
                Objects.equals(address, oldPeople.address) &&
                Objects.equals(sex, oldPeople.sex) &&
                Objects.equals(birthday, oldPeople.birthday) &&
                Objects.equals(familyPhone, oldPeople.familyPhone) &&
                Objects.equals(entryDate, oldPeople.entryDate) &&
                Objects.equals(leaveDate, oldPeople.leaveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldPeopleId, idCard, photo, name, telephone, address, sex, birthday, familyPhone, entryDate, leaveDate);
    }

}
