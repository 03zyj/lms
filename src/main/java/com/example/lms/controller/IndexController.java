package com.example.lms.controller;

import com.example.lms.bean.Courses;
import com.example.lms.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    CoursesService coursesService;
    @GetMapping("/")
    String index(Model model) {
        List<Courses> coursesList = coursesService.findAll();
        model.addAttribute("coursesList", coursesList);
        return "index";
    }

    /*新增加*/
    @GetMapping("/resources")
    String resources() {
        return "resources";
    }

    @GetMapping("/resources_show")
    String resources_show() {
        return "resources-show";
    }
}
