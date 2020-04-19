package com.tony.heproject.controller.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StatusController {
    @RequestMapping("/runningStatus")
    public String runningStatus(){
        return "/runningStatus";
    }

}




