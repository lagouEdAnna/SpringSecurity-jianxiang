package com.lagou.springsecurity.controller;

import com.lagou.springsecurity.domain.AuthCode;
import com.lagou.springsecurity.domain.User;
import com.lagou.springsecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    //添加User
    @PostMapping("/user/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    //通过用户名/密码对用户进行首次认证
    @PostMapping("/user/auth")
    public void auth(@RequestBody User user) {
        userService.auth(user);
    }

    //通过用户名/认证码进行二次认证
    @PostMapping("/authcode/check")
    public void check(@RequestBody AuthCode authCode, HttpServletResponse response) {
        if (userService.check(authCode)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
