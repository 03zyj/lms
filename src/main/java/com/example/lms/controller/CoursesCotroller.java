//package com.example.lms.controller;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.lms.bean.Courses;
//import com.example.lms.bean.User;
//import com.example.lms.service.CoursesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class CoursesCotroller {
//    @Autowired
//    CoursesService coursesService;
//    @GetMapping("courses")
//    public String courses(@RequestParam(value = "p", defaultValue = "1") Integer p, Model model) {
//        Page<Courses> page = coursesService.page(new Page<>(p, 3));
//        model.addAttribute("page", page);
//        return "/backend/courses";
//    }
//}
