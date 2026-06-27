package com.spring_fast.main.controller.web_processor;

import com.spring_fast.main.service.LoginCounterService;
import com.spring_fast.main.service.SessionLoginService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;
    private final SessionLoginService sessionLoginService;
    private final LoginCounterService loginCounterService;

    public LoginProcessor(
            SessionLoginService sessionLoginService,
            LoginCounterService loginCounterService
    ) {
        this.sessionLoginService = sessionLoginService;
        this.loginCounterService = loginCounterService;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String username, String password) {
        loginCounterService.increment();

        if (username.equals("nataly") && password.equals("password")) {
            sessionLoginService.setUsername(username);
            return true;
        }
        else return false;
    }
}
