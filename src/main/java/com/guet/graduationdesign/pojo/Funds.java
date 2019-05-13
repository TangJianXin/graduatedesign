package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
public class Funds {
    private int fundsId;
    private Float amount;
    private int flag;
    private String detail;
    private Date date;
    private Employer employerByOperator;

    @Id
    @Column(name = "funds_id")
    public int getFundsId() {
        return fundsId;
    }

    public void setFundsId(int fundsId) {
        this.fundsId = fundsId;
    }

    @Basic
    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "flag")
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        Funds funds = (Funds) o;
        return fundsId == funds.fundsId &&
                Double.compare(funds.amount, amount) == 0 &&
                flag == funds.flag &&
                Objects.equals(detail, funds.detail) &&
                Objects.equals(date, funds.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundsId, amount, flag, detail, date);
    }

    @ManyToOne
    @JoinColumn(name = "operator", referencedColumnName = "employer_Id", nullable = false)
    public Employer getEmployerByOperator() {
        return employerByOperator;
    }

    public void setEmployerByOperator(Employer employerByOperator) {
        this.employerByOperator = employerByOperator;
    }
}
