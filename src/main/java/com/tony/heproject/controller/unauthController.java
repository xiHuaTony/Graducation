package com.tony.heproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class unauthController {
    @RequestMapping("/unauth")
    public String unauth(){
        return "unauth";
    }

}




