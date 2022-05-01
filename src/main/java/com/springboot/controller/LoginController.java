package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    final HttpSession session;

    @Autowired
    public LoginController(HttpSession session) {
        this.session = session;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPagePost() {
        return "select";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request) {
        request.getSession().removeAttribute("userInfo");
        return "login";
    }
}
