package com.lagou.springsecurity.sso.app1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.version}")
    private String version;

    @Value("${app2.profile-uri}")
    public String app2ProfileUri;

    @RequestMapping("/profile")
    public Object profile(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("version", version);
        model.addAttribute("app2ProfileUri", app2ProfileUri);

        return "/system/profile";
    }

}
