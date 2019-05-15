package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
public class Quota {
    private int quotaId;
    private int heartRate;
    private int breatheRate;
    private Float temperature;
    private Date date;
    private OldPeople oldPeopleByOldpeople;

    @Id
    @Column(name = "quota_id")
    public int getQuotaId() {
        return quotaId;
    }

    public void setQuotaId(int quotaId) {
        this.quotaId = quotaId;
    }

    @Basic
    @Column(name = "heart_rate")
    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    @Basic
    @Column(name = "breathe_rate")
    public int getBreatheRate() {
        return breatheRate;
    }

    public void setBreatheRate(int breatheRate) {
        this.breatheRate = breatheRate;
    }

    @Basic
    @Column(name = "temperature")
    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quota quota = (Quota) o;
        return quotaId == quota.quotaId &&
                heartRate == quota.heartRate &&
                breatheRate == quota.breatheRate &&
                Double.compare(quota.temperature, temperature) == 0 &&
                Objects.equals(date, quota.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quotaId, heartRate, breatheRate, temperature, date);
    }

    @ManyToOne
    @JoinColumn(name = "oldpeople", referencedColumnName = "old_people_id", nullable = false)
    public OldPeople getOldPeopleByOldpeople() {
        return oldPeopleByOldpeople;
    }

    public void setOldPeopleByOldpeople(OldPeople oldPeopleByOldpeople) {
        this.oldPeopleByOldpeople = oldPeopleByOldpeople;
    }
}
