package com.spring.market.config;

import com.spring.market.config.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    /**
     * 비밀번호 암호화 (IoC에 등록 되있어서 빈주입 후 사용하면 된다.)
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring Security 관련 설정 하는곳
     */
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.cors().configurationSource(configurationSource());

        // Jwt 사용 하겠다.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // react 또는 앱으로 요청 예정 (formLogin, httpBasic 사용안함)
        http.formLogin().disable();
        http.httpBasic().disable();

        // 필터 적용
        http.apply(new CustomSecurityFilter());

        // API 인증 및 권한 관리
        http.authorizeRequests(authorize ->
                authorize.antMatchers("/api/v1/test").access("hasRole('ROLE_USER')")
                        .anyRequest().permitAll());

        return http.build();
    }

    /**
     * Filter 추가 하는곳 (Jwt 필터 만들어서 추가 하면 된다)
     */
    public class CustomSecurityFilter extends AbstractHttpConfigurer<CustomSecurityFilter, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder.addFilter(new JwtAuthenticationFilter(authenticationManager));

        }
    }

    /**
     * Cors 설정 하는곳
     */
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*"); // GET, POST, PUT, DELETE (Javascript 요청 허용)
        configuration.addAllowedOriginPattern("*"); // 모든 IP 주소 허용 (프론트 엔드 IP만 허용 react)
        configuration.setAllowCredentials(true); // 클라이언트에서 쿠키 요청 허용
        configuration.addExposedHeader("Authorization"); // 옛날에는 디폴트, 지금은 아니다.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
