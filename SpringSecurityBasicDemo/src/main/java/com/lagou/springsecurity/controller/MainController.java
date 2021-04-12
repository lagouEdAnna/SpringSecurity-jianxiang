package com.lagou.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lagou.springsecurity.service.HealthRecordService;

@Controller
public class MainController {

    @Autowired
    private HealthRecordService healthRecordService;
    
    @GetMapping("/main")
    public String main(Authentication a, Model model) {
    	String userName = a.getName();
        model.addAttribute("username", userName);
        model.addAttribute("healthRecords", healthRecordService.getHealthRecordsByUsername(userName));
        return "main.html";
    }
}
