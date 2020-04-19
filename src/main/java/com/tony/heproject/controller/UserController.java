package com.tony.heproject.controller;

import com.tony.heproject.bean.User;
import com.tony.heproject.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController{
    @Autowired
    private UserService userService;

    /**
     * 跳转到all.html界面 然后通关url获取到下一个方法中的json格式数据
     * @return
     */
    @RequestMapping("/all")
    public String all(Model model,HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "/all";
    }


    /**
     * 查询全部数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public Map<String, Object> userList() {

        Map<String, Object> resultMap = new HashMap<>();
        List<User> userList = userService.selectAllUsers();
        //避免出现数据接口异常的错误！
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", "1000");
        resultMap.put("data", userList);
        return resultMap;
    }

    /**
     * 更新信息
     * @return
     */
    @RequestMapping("/user/toUpdate")
    public String toUpdate(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "update";

    }

    /**
     * 添加信息
     *
     * @return
     */
    @RequestMapping("/user/toAdd")
    public String toAdd() {
        return "user";
    }

    /**
     * 添加或修改
     *
     * @param user
     * @return
     */
    @RequestMapping("/user/addOrUpdate")
    public String addOrUpdate(User user) {
        //注册的密码
        Object credentials = user.getPwd();
        String hashAlgorithmName = "MD5";
        int hashIterations = 2;
        String account = user.getAccount();
        ByteSource salt = ByteSource.Util.bytes(account);
        Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        user.setPwd(obj.toString());
        if (user.getId() == null) {
            //添加
            userService.addUser(user);
        } else {
            //修改
            userService.updateUser(user);
            return "redirect:/homePage";
        }
        return "redirect:/login";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/delete")
    public String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);

        return "redirect:/all";
    }

    /**
     * 登录功能
     */
    @RequestMapping(method = RequestMethod.POST, value = "/check")
    public String login(@RequestParam("account") String account,
                        @RequestParam("pwd") String pwd, Map<String, Object> map, Model model, HttpSession session) {

        Subject currentUser = SecurityUtils.getSubject();

        // 当前是否认证（登录）
        if (!currentUser.isAuthenticated()) {
            // 前端用户传过来的用户名和密码
            UsernamePasswordToken token = new UsernamePasswordToken(account, pwd);
            //记住我
            token.setRememberMe(true);
            try {
                //认证（登录）功能
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                map.put("msg", uae.getMessage());
                return "/login";
            } catch (IncorrectCredentialsException ice) {
                map.put("msg", "密码输入错误");
                return "/login";
            } catch (LockedAccountException lae) {
                map.put("msg", lae.getMessage());
                return "/login";
            } catch (AuthenticationException ae) {  //认证（登录）异常
            }
        }
        //更新用户信息时需要id
        User user = userService.selectUserByAccount(account);
        session.setAttribute("user", user);
        User u = (User) session.getAttribute("user");
        model.addAttribute("user", u);
        return "/homePage";
    }

}



