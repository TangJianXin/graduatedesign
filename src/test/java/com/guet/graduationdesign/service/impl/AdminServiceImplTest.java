package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.pojo.Admin;
import com.guet.graduationdesign.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Test
    public void findByUsername() {
        Admin admin = adminService.findByUsername("admin");
        Assert.assertEquals("123456",admin.getPassword());
    }
}