package com.spring.market.mapper;

import com.spring.market.model.LoginDto;
import com.spring.market.model.Test;
import com.spring.market.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface TestMapper {
    Test test1();


    User findUser(LoginDto loginDto);
}
