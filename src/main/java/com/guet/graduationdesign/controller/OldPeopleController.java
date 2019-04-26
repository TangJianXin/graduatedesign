package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.service.OldPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oldPeople")
public class OldPeopleController {

    @Autowired
    private OldPeopleService oldPeopleService;
}
