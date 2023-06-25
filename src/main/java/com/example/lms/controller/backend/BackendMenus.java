package com.example.lms.controller.backend;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "backend")
@Data
public class BackendMenus {
    private List<Menu> menus;
}

@Data
class Menu {
    public String name;
    public String url;
    public String icon;
}
