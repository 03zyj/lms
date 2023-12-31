package com.example.lms.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lms.bean.Courses;
import com.example.lms.bean.User;
import com.example.lms.bean.VideoUpload;
import com.example.lms.mapper.VideoUploadMapper;
import com.example.lms.service.CoursesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/backend")
public class BackendController {
    @Autowired
    CoursesService coursesService;
    @Autowired
    VideoUploadMapper videoUploadMapper;
    @GetMapping("dashboard")
    String dashboard() {
        return "backend/dashboard";
    }
    @GetMapping("empty")
    String empty() {
        return "backend/empty";
    }
   @GetMapping("courses")
    String courses(Model model) {
       List<Courses> coursesList = coursesService.findAll();
       model.addAttribute("coursesList", coursesList);
        return "backend/courses";
    }
    @GetMapping("videos")
    String videos(HttpServletRequest request) {
        List<VideoUpload> videoUploads = videoUploadMapper.SelectVideoAll();
        request.setAttribute("videoList",videoUploads);
        return "backend/videos";
    }
    @GetMapping("videos_show")
    String video_show() {
        return "backend/videos_show";
    }
    @GetMapping("video")
    String videos() {
        return "backend/video";
    }
//    @GetMapping("courses")
//    public String courses(@RequestParam(value = "p", defaultValue = "1") Integer p, Model model) {
//        Page<Courses> page = coursesService.page(new Page<>(p, 3));
//        model.addAttribute("page", page);
//        return "backend/courses";
//    }
}
