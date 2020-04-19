package com.tony.heproject.controller;

import com.tony.heproject.bean.User;
import com.tony.heproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class teacherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/application")
    public String application(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
       return "/application";
    }

    @RequestMapping("/setScore")
    public String setScore(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);return "/setScore";
    }

}




