package com.tony.heproject.controller;

import com.tony.heproject.bean.Institute;
import com.tony.heproject.service.InstituteService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RunWith(SpringRunner.class)
@SpringBootTest
/** 学院
 * @author :Tony
 */
public class InstituteController {
    @Autowired
    private InstituteService instituteService;

    /**
     * 查询全部数据
     */
    @RequestMapping(value = "/instituteList")
    @ResponseBody
    public Map<String, Object> instituteList() {
        Map<String, Object> resultMap = new HashMap<>();
        List<Institute> instituteList = instituteService.selectAllInstitutes();
        //避免出现数据接口异常的错误！
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", instituteList);
        return resultMap;
    }



    /**
     * 添加
     *
     * @return
     */
    @RequestMapping("/institute/toAdd")
    public String addInstitute(Institute institute) {
        instituteService.addInstitute(institute);
        return "redirect:/examine";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/institute/delete")
    public String deleteInstitute(@RequestParam("id") int id){
        instituteService.deleteInstitute(id);
        return "redirect:/examine";
    }


}




