package com.spring_fast.main.controller;

import com.spring_fast.main.service.LoginCounterService;
import com.spring_fast.main.service.SessionLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final SessionLoginService sessionLoginService;
    private final LoginCounterService loginCounterService;

    public MainController(
            SessionLoginService sessionLoginService,
            LoginCounterService loginCounterService
    ) {
        this.sessionLoginService = sessionLoginService;
        this.loginCounterService = loginCounterService;
    }

    @GetMapping("/home_dynamic")
    public String home(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name,
            Model page
    ) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home_dynamic.html";
    }

    @GetMapping("home_dynamic/{color}")
    public String home(
            @PathVariable String color,
            Model page
    ) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", color);
        return "home_dynamic.html";
    }

    @GetMapping("/main")
    public String homeScreen(
        @RequestParam(required = false) String logout,
        Model model
    ) {
        if (logout != null) sessionLoginService.setUsername(null);

        String username = sessionLoginService.getUser();
        int count = loginCounterService.getCounter();

        if (username == null) return "redirect:/";
        else {
            model.addAttribute("username", username);
            model.addAttribute("count", count);
            return "main.html";
        }
    }
}
