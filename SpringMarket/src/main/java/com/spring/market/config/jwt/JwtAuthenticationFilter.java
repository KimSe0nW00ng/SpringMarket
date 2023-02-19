package com.spring.market.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.market.config.auth.PrincipalDetails;
import com.spring.market.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        private final AuthenticationManager authenticationManger;



    public JwtAuthenticationFilter(AuthenticationManager authenticationManger) {
        super(authenticationManger);
        this.authenticationManger = authenticationManger;
    }

    // 로그인 요청을 하면 로그인 시도를 위해 실행되는 함수
        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)  throws AuthenticationException{
            System.out.println("jwtAuthenticationFilter 로그인 시도중");

            try {
                /*BufferedReader br = request.getReader();

                String input = null;
                while ((input = br.readLine()) != null){
                    System.out.println(input);
                }*/
                //System.out.println(request.getInputStream().toString());

                ObjectMapper om = new ObjectMapper();
                User user = om.readValue(request.getInputStream(), User.class);
                System.out.println(user);



                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user.getMember_id(), user.getMember_password());

                Authentication authentication = authenticationManger.authenticate(authenticationToken);


                PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
                System.out.println("로그인 정상적! "+principalDetails.getUser().getMember_id());
                return authentication;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //return super.attemptAuthentication(request,response);
            return null;
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authResult)throws  IOException, ServletException {
            System.out.println("인증이 완료됨");
            PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

            String jwtToken = JWT.create()
                    .withSubject(principalDetails.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis()+60000 * 10))
                    .withClaim("member_id",principalDetails.getUser().getMember_id())
                    .withClaim("member_name", principalDetails.getUser().getMember_name())
                    .sign(Algorithm.HMAC512("token"));
            System.out.println("토큰00" + jwtToken);

            response.addHeader("Authorization", "Bearer "+ jwtToken);

            //super.successfulAuthentication(request,response,filterChain,authResult);
        }

}
