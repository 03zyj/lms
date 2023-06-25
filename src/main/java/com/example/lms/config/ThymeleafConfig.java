package com.example.lms.config;

import com.example.lms.controller.backend.BackendMenus;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ThymeleafConfig {
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;
    @Autowired
    private BackendMenus backendMenus;

    @PostConstruct
    public void init() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("menus", backendMenus.getMenus());
        thymeleafViewResolver.setStaticVariables(variables);
    }
}
