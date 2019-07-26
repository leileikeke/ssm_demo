package com.leike.controller;

import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-25 18:54
 */
@Controller
@RequestMapping("/user")
public class UserController {

    // 自动注入UserService
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        //数据库查询
        user = userService.get(user);
        System.out.println("login....");
        if (user != null) {
            //将用户信息存储到会话当中
            session.setAttribute("SESSION_USER", user);
            return "msg";
        } else {
            model.addAttribute("msg", "账号或者密码错误");//因为用的是重定向,所以msg会失效

            session.setAttribute("msg", "账号或者密码错误");//存到会话中就没问题了
            return "redirect:/jsp/login.jsp";
        }
    }

    @RequestMapping("/delete/{name}")
    @ResponseBody
    public Map<String,Integer> delete(@PathVariable("name") String name) {
        //数据库查询
        boolean deleteSuc = userService.delete(name);
        int code = deleteSuc?2000:2003;
        Map<String, Integer> map = new HashMap<>();
        map.put("code",code);
        return map;
    }

}
