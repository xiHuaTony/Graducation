package com.tony.heproject.controller;
import com.tony.heproject.bean.Course;
import com.tony.heproject.bean.Institute;
import com.tony.heproject.bean.User;
import com.tony.heproject.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExamineController {

    @Autowired
    private ExamineService examineService;


    @RequestMapping("/examine")
    public String examine(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "/examine";
    }

    @RequestMapping(value = "/examineList")
    @ResponseBody
    public Map<String, Object>  examineList( HttpSession session){
        User user = (User) session.getAttribute("user");
        String s = user.getSchool();
        Map<String, Object> resultMap = new HashMap<>();
        List<Course> examineList = examineService.selectExamineList(s);
        //避免出现数据接口异常的错误！
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", examineList);
        return resultMap;
        }

    }

