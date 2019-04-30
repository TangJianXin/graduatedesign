package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
public class Admin {
    private String username;
    private String password;
    private Employer employerByEmployerId;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return Objects.equals(username, admin.username) &&
                Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @ManyToOne
    @JoinColumn(name = "employer_Id", referencedColumnName = "employer_Id", nullable = false)
    public Employer getEmployerByEmployerId() {
        return employerByEmployerId;
    }

    public void setEmployerByEmployerId(Employer employerByEmployerId) {
        this.employerByEmployerId = employerByEmployerId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employerByEmployerId=" + employerByEmployerId +
                '}';
    }
}
