package com.spring.market.service.impl;

import com.spring.market.model.LoginDto;
import com.spring.market.model.Test;
import com.spring.market.mapper.TestMapper;
import com.spring.market.model.User;
import com.spring.market.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper tm;
    @Override
    public Test test1() {
        return tm.test1();
    }

    @Override
    public User findUser(LoginDto loginDto){
        User user = tm.findUser(loginDto);

        if (user == null){
            System.out.println("널임");
        }

        return user;
    }
}
