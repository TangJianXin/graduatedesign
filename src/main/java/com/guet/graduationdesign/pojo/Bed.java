package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
public class Bed {
    private String bedId;
    private Employer employerByEmployerId;
    private OldPeople oldPeopleByOldPeopleId;

    @Id
    @Column(name = "bed_id")
    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return Objects.equals(bedId, bed.bedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedId);
    }

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "employer_Id", nullable = false)
    public Employer getEmployerByEmployerId() {
        return employerByEmployerId;
    }

    public void setEmployerByEmployerId(Employer employerByEmployerId) {
        this.employerByEmployerId = employerByEmployerId;
    }

    @ManyToOne
    @JoinColumn(name = "old_people_id", referencedColumnName = "old_people_id", nullable = false)
    public OldPeople getOldPeopleByOldPeopleId() {
        return oldPeopleByOldPeopleId;
    }

    public void setOldPeopleByOldPeopleId(OldPeople oldPeopleByOldPeopleId) {
        this.oldPeopleByOldPeopleId = oldPeopleByOldPeopleId;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "bedId='" + bedId + '\'' +
                ", employerByEmployerId=" + employerByEmployerId +
                ", oldPeopleByOldPeopleId=" + oldPeopleByOldPeopleId +
                '}';
    }
}
