package com.lagou.springsecurity.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthCodeAuthentication extends UsernamePasswordAuthenticationToken {

    public AuthCodeAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
