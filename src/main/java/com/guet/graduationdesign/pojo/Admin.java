package com.guet.graduationdesign.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Admin {
    private String adminname;
    private String password;
    private Employer employerByEmployerId;

    @Id
    @Column(name = "adminname")
    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminname, admin.adminname) &&
                Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminname, password);
    }

    @ManyToOne
    @JoinColumn(name = "employer_Id", referencedColumnName = "employer_Id", nullable = false)
    public Employer getEmployerByEmployerId() {
        return employerByEmployerId;
    }

    public void setEmployerByEmployerId(Employer employerByEmployerId) {
        this.employerByEmployerId = employerByEmployerId;
    }
}
