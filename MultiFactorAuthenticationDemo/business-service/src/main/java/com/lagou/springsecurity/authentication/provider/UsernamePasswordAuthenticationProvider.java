package com.lagou.springsecurity.authentication.provider;

import com.lagou.springsecurity.authentication.UsernamePasswordAuthentication;
import com.lagou.springsecurity.authentication.facade.AuthenticationServerFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationServerFacade authServer;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        
        //调用认证服务完成认证
        authServer.checkPassword(username, password);
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthentication.class.isAssignableFrom(aClass);
    }
}
