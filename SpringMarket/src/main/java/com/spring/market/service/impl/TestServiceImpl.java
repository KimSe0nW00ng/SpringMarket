package com.spring.market.service.impl;

import com.spring.market.model.Test;
import com.spring.market.mapper.TestMapper;
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
}
