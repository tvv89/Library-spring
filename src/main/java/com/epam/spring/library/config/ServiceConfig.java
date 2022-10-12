package com.epam.spring.library.config;

import com.epam.spring.library.service.UserService;
import com.epam.spring.library.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
