package com.tony.heproject.controller;

import com.tony.heproject.bean.User;
import com.tony.heproject.bean.score_look;
import com.tony.heproject.bean.user_course;
import com.tony.heproject.service.ScoreService;
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
public class ScoreController {

    @Autowired
    private ScoreService scoreService;


    @RequestMapping("/getScores")
    @ResponseBody
    public Map<String, Object> getScores(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        String teacher = user.getUname();
        Map<String, Object> resultMap = new HashMap<>();
        List<user_course> getScores = scoreService.getScores(teacher);
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", getScores);
        return resultMap;

    }

    @RequestMapping("/setScores")
    @ResponseBody
    public Map<String, Object> setScores(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        String teacher = user.getUname();
        Map<String, Object> resultMap = new HashMap<>();
        List<user_course> setScores = scoreService.setScores(teacher);
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", setScores);
        return resultMap;

    }

    @RequestMapping("/scoresLook")
    @ResponseBody
    public Map<String, Object> scoresLook(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        String teacher = user.getUname();
        Map<String, Object> resultMap = new HashMap<>();
        List<score_look> score_look = scoreService.scoresLook(teacher);
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", score_look);
        return resultMap;

    }

    @RequestMapping("/score/toSet")
    public String scoreToSet(Integer account,Integer courseNum,Integer score,Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        scoreService.scoreToSet(account,courseNum,score);
        return "/setScore";
    }


}




