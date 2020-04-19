package com.tony.heproject.controller;

import com.tony.heproject.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class homePageController {
    @RequestMapping("/homePage")
    public String homePage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "homePage";
    }

}




