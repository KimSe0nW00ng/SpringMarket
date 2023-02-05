package com.spring.market.mapper;

import com.spring.market.model.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    Test test1();
}
