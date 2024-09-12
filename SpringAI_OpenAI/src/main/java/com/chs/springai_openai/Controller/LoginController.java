package com.chs.springai_openai.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private static final String USERNAME = "1";
    private static final String PASSWORD = "1";

    @PostMapping("/")
    public ModelAndView login(
            @RequestParam("username") String username,
            @RequestParam("userpwd") String password) {

        ModelAndView mav = new ModelAndView();

        // 检查用户名和密码
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // 登录成功，重定向到 index.html
            mav.setViewName("redirect:/index.html");
        } else {
            // 登录失败，重定向回 login.html 并显示错误信息
            mav.setViewName("redirect:login.html");
            mav.addObject("msg", "用户名或密码错误！");
        }

        return mav;
    }
}

