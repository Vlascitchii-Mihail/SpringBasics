package com.spring_fast.main.controller;

import com.spring_fast.main.controller.web_processor.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String getLoginPage() {
        return "login.html";
    }

    @PostMapping("/")
    public String postUserData(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        boolean loggedIn = loginProcessor.login(username, password);

        if (loggedIn) {
            return "redirect:/main";
        } else {
            model.addAttribute("message", "Login failed!");
            return "login.html";
        }
    }
}
