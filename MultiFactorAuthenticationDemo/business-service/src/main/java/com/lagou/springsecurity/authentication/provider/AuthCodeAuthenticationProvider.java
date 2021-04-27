package com.lagou.springsecurity.authentication.provider;

import com.lagou.springsecurity.authentication.AuthCodeAuthentication;
import com.lagou.springsecurity.authentication.facade.AuthenticationServerFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthCodeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationServerFacade authServer;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String code = String.valueOf(authentication.getCredentials());
        
        //调用认证服务完成认证
        boolean result = authServer.checkAuthCode(username, code);

        if (result) {
            return new AuthCodeAuthentication(username, code);
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }

    public boolean supports(Class<?> aClass) {
        return AuthCodeAuthentication.class.isAssignableFrom(aClass);
    }
}
