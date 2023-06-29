package com.example.lms.controller;

import com.example.lms.mapper.VideoUploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class uploadVideoController {
    @Autowired
    private VideoUploadMapper videoUploadMapper;
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(value = "/uploadVideo3")
    @ResponseBody

    public Map<String,String> savaVideoTest(@RequestParam("file") MultipartFile file,@RequestParam String SavePath)
            throws IllegalStateException {
        Map<String,String> resultMap = new HashMap<>();
        try{
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVideoName = pikId + "." + fileExt;
            System.out.println("重构文件名防止上传同名文件："+newVideoName);
            String videoNameText = file.getOriginalFilename();
            System.out.println("视频原名:"+videoNameText);
            String videoUrl = "C:/xiangmu/shixun/mylms/src/main/resources/static/img/videos" + "/" + newVideoName;
            videoUploadMapper.save(videoNameText,videoUrl,newVideoName);
            File filepath = new File("C:/xiangmu/shixun/mylms/src/main/resources/static/img/videos", file.getOriginalFilename());
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            File fileSave = new File("C:/xiangmu/shixun/mylms/src/main/resources/static/img/videos", newVideoName);
            file.transferTo(fileSave);
            resultMap.put("newVideoName",newVideoName);
            resultMap.put("resCode","200");
            resultMap.put("VideoUrl",SavePath + "/" + newVideoName);
            return  resultMap;

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            resultMap.put("resCode","400");
            return  resultMap ;

        }
    }




}
