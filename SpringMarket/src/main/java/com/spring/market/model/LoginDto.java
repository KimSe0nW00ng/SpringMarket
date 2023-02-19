package com.spring.market.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class LoginDto {
    private String member_id;
    private String member_password;
}
