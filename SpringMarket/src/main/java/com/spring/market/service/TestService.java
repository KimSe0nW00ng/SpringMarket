package com.spring.market.service;

import com.spring.market.model.LoginDto;
import com.spring.market.model.Test;
import com.spring.market.model.User;


public interface TestService {

    public Test test1();

    public User findUser(LoginDto loginDto);
}
