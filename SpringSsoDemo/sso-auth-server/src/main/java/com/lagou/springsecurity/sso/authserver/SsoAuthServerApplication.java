package com.lagou.springsecurity.sso.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class SsoAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoAuthServerApplication.class, args);
    }

}
