package com.spring_fast.main.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.spring_fast.main.proxy")
public class FeignConfig {
}
