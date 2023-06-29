package com.example.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {

    @GetMapping("/video")
    public String video() {
        // 处理 /video 的逻辑

        return "video";
    }

    @GetMapping("/video-show")
    public String videoShow() {
        // 处理 /video-show 的逻辑
        return "video-show";
    }

    }

