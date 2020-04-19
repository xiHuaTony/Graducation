package com.tony.heproject.controller;
import com.tony.heproject.bean.School;
import com.tony.heproject.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    /**
     * 跳转到all.html界面 然后通关url获取到下一个方法中的json格式数据
     */
    @RequestMapping("/deviceManage")
    public String hospital() {
        return "/src/main/resources/templates/old/deviceManage.html";
    }


    /**
     * 查询全部数据
     * @param
     * @return
     */
    @RequestMapping(value = "/schoolList")
    @ResponseBody
    public Map<String, Object> schoolList() {
        Map<String, Object> resultMap = new HashMap<>();
        List<School> schoolList = schoolService.selectAllSchools();
        //避免出现数据接口异常的错误！
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", schoolList);
        return resultMap;
    }

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping("/school/toAdd")
    public String addSchool(School school) {
        List<School> schoolList = schoolService.selectAllSchools();
        for (School s : schoolList) {
            if (s.getSname().equals(school.getSname())) {
                return "redirect:/deviceManage";
            }
        }
        schoolService.addSchool(school);
        return "redirect:/deviceManage";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/school/delete")
    public String deleteSchool(@RequestParam("id") int id){
        schoolService.deleteSchool(id);
        return "redirect:/deviceManage";
    }


}




