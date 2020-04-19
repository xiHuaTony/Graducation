package com.tony.heproject.controller;

import com.tony.heproject.bean.user_course;
import com.tony.heproject.bean.Course;
import com.tony.heproject.bean.User;
import com.tony.heproject.service.CourseService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseController {



    @Autowired
    private CourseService courseService;

    /**
     * 查询全部数据
     */
    @RequestMapping(value = "/courseList")
    @ResponseBody
    public Map<String, Object> courseList(HttpSession session) {
        User user = (User) session.getAttribute("user");
        String teacher = user.getUname();
        String school = user.getSchool();
        Map<String, Object> resultMap = new HashMap<>();
        List<Course> courseList = courseService.selectAllCourses(teacher,school);
        //避免出现数据接口异常的错误！
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", courseList);
        return resultMap;
    }


    @RequestMapping(value = "/uncheckList")
    @ResponseBody
    public Map<String, Object> uncheckList(HttpSession session) {
        User user = (User) session.getAttribute("user");
        String teacher = user.getUname();
        String school = user.getSchool();
        Map<String, Object> resultMap = new HashMap<>();
        List<user_course> uncheckList = courseService.uncheckList(teacher, school);
        //避免出现数据接口异常的错误！
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", uncheckList);
        return resultMap;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/course/toAdd")
    public String addCourse(Course course) {
        courseService.addCourse(course);
        return "redirect:/application";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/course/delete")
    public String deleteCourse(@RequestParam("id") int id) {
        courseService.deleteCourse(id);
        return "redirect:/application";
    }

}



