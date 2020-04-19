package com.tony.heproject.controller.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutRegistController {
    @RequestMapping("/outRegist")
    public String OutRegistController(){
        return "/src/main/resources/templates/old/outRegist.html";
    }

}




