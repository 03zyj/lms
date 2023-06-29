package com.example.lms.controller;


import com.example.lms.Util.NonStaticResourceHttpRequestHandler;
import com.example.lms.bean.VideoUpload;
import com.example.lms.mapper.VideoUploadMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/SelectVideo")
@AllArgsConstructor
public class SelectVideoController {
    private final NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;
    @Autowired
    VideoUploadMapper videoUploadMapper;
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/policemen/{videoId}")
    public void videoPreview(HttpServletRequest request, HttpServletResponse response,@PathVariable("videoId") Integer videoId) throws Exception {
        VideoUpload videoPathList = videoUploadMapper.SelectVideoId(videoId);
        String videoPathUrl=videoPathList.getVideoUrl();
        Path filePath = Paths.get(videoPathUrl );
        if (Files.exists(filePath)) {
            String mimeType = Files.probeContentType(filePath);
            if (StringUtils.hasText(mimeType)) {
                response.setContentType("video/mp4");
            }
            //转换视频流部分
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/table")
    public List<VideoUpload> videoTable() {
        return videoUploadMapper.SelectVideoAll();
    }



}