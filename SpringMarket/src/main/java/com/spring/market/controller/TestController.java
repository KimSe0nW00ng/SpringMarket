package com.spring.market.controller;

import com.spring.market.model.Test;
import com.spring.market.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private TestService tService;

    @GetMapping("/test")
    public Test test1(){
        Test dto = tService.test1();
        System.out.println(dto.getTest());
        System.out.println("와이");
        return dto;
    }
}
