package com.example.lms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lms.bean.Chapter;
import com.example.lms.bean.City;
import com.example.lms.bean.Courses;
import com.example.lms.bean.User;
import com.example.lms.service.ChapterService;
import com.example.lms.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoursesCotroller {
    @Autowired
    CoursesService coursesService;
    @Autowired
    ChapterService chapterService;
    @GetMapping("/courses/{id}")
    public String findById(@PathVariable Integer id,Model model) {
        Courses courses = coursesService.findById(id);
        Chapter chapter = chapterService.findById(id);
        model.addAttribute("chapter", chapter);
        model.addAttribute("courses", courses);
        return "courseDetail";
    }
}
