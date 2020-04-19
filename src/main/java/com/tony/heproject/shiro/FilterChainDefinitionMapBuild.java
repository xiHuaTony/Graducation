package com.tony.heproject.shiro;
import com.tony.heproject.bean.Resources;
import com.tony.heproject.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname FilterChainDefinitionMapBuild
 * @Author Tony
 * @Description TODO
 * @Date 2020/01/10 11:03
 * @Created by Administrator
 */
@Controller
public class FilterChainDefinitionMapBuild {

    /**
     * 方法：在数据库中查询所有的资源相关配置

     /list.jsp = anon
     /user/login= anon
     /aaa/logout= logout
     /teacher.jsp=roles[tea]
     /student.jsp=roles[stu]
     /admin.jsp=roles[tea,stu]
     /** = authc
     map.put("/list.jsp","anon");
     map.put("/user/login","anon");
     map.put("/aaa/logout","logout");
     map.put("/teacher.jsp","roles[tea]");
     map.put("/student.jsp","roles[stu]");
     map.put("/admin.jsp","roles[tea,stu]");
     map.put("/**","authc");
     */
    @Autowired
    private ResourcesService resourcesService;
    public Map<String, String> build(){
        //查询数据库的所有数据
        Map<String,String> map=new LinkedHashMap<>();
        List<Resources> list= resourcesService.selectListBySortNum();
        for(Resources r:list){
            map.put(r.getKeyurl(),r.getFiltername());
        }
        return map;
    }

}
