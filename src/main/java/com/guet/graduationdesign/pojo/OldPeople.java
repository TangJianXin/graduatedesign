package com.guet.graduationdesign.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
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
    private Collection<Bed> bedsByOldPeopleId;

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
                Objects.equals(familyPhone, oldPeople.familyPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldPeopleId, idCard, photo, name, telephone, address, sex, birthday, familyPhone);
    }

    @OneToMany(mappedBy = "oldPeopleByOldPeopleId")
    public Collection<Bed> getBedsByOldPeopleId() {
        return bedsByOldPeopleId;
    }

    public void setBedsByOldPeopleId(Collection<Bed> bedsByOldPeopleId) {
        this.bedsByOldPeopleId = bedsByOldPeopleId;
    }
}
