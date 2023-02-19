package com.spring.market.config.auth;

import com.spring.market.model.LoginDto;
import com.spring.market.model.User;
import com.spring.market.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final TestService testService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailService");
        LoginDto loginDto = new LoginDto();
        loginDto.setMember_id(username);
        User user = testService.findUser(loginDto);
        System.out.println("+++++++++++++++++++++++");
        System.out.println(user);
        return new PrincipalDetails(user);
    }



}
