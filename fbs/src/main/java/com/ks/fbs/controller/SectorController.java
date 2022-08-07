package com.ks.fbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SectorController {

    @GetMapping("/sector")
    public String sectorPage(Model model){
        return "";
    }
}
