package com.guet.graduationdesign.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Bed {
    private int bedId;
    private Employer employerByEmployerId;
    private OldPeople oldPeopleByOldPeopleId;

    @Id
    @Column(name = "bed_id")
    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return bedId == bed.bedId;
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
}
