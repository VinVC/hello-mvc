package com.foo.web02.controller;

import javax.servlet.http.HttpSession;

import com.foo.web02.bean.User;
import com.foo.web02.framework.GetMapping;
import com.foo.web02.framework.ModelAndView;

public class IndexController {
    @GetMapping("/")
    public ModelAndView index(HttpSession session, String name) {
        session.setAttribute("user", new User("123456@gmail.com", "b1", name, "d1"));
        return new ModelAndView("/hello.html", "name", name);
    }

     @GetMapping("/user")
    public ModelAndView s(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new ModelAndView("/user.html", "user", user);
    }

    @GetMapping("/hello")
    public ModelAndView hello(String name) {
        if (name == null) {
            name = "World";
        }
        return new ModelAndView("/hello.html", "name", name);
    }
}