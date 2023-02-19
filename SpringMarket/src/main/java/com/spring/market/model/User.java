package com.spring.market.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter @ToString
public class User {

    private String member_id;
    private String member_password;
    private String member_name;
    private String phone_number;
    private String reg_date;
    private String member_roles;

    public List<String> getRoleList(){
        if(this.member_roles.length()>0){
            return Arrays.asList(this.member_roles.split(","));
        }
        return new ArrayList<>();
    }
}
