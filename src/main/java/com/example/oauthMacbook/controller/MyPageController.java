package com.example.oauthMacbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/meineSeite")
    public String successfullLoginPage(){
        return "meineSeite";
    }
}
