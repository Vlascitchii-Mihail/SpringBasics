package com.spring_fast.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class SessionLoginService {

    private String username;

    public String getUser() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
