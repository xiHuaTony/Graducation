package com.tony.heproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class finishedController {
    @RequestMapping("/finished")
    public String homePage(){
        return "homePage";
    }

}




