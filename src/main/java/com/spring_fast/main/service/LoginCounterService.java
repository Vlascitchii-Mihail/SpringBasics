package com.spring_fast.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCounterService {

    private int counter;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
