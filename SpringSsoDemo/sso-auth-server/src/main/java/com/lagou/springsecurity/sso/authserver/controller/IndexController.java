package com.lagou.springsecurity.sso.authserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class IndexController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.version}")
    private String version;

    @Value("${app1.profile-uri}")
    public String app1ProfileUri;

    @Value("${app2.profile-uri}")
    public String app2ProfileUri;

    @RequestMapping("/index")
    public String index(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("name", name);
        model.addAttribute("version", version);
        model.addAttribute("app1ProfileUri", app1ProfileUri);
        model.addAttribute("app2ProfileUri", app2ProfileUri);

        return "index";
    }

}
