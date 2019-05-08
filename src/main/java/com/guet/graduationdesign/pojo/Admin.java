package com.guet.graduationdesign.pojo;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
public class Admin {
    private String username;
    private String password;
    private Date registerDate;
    private String image;
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

    @Basic
    @Column(name = "register_Date")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(username, admin.username) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(registerDate, admin.registerDate) &&
                Objects.equals(image, admin.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, registerDate, image);
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
