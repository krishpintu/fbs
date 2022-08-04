package com.ks.fbs.controller;

import com.ks.fbs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String viewHomePage() {
        return "/index";
    }

    @RequestMapping({"/","/index","/home"})
    public String homePage(){
        return "/pages/index";
    }




}
