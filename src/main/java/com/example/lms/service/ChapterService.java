package com.example.lms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lms.bean.Chapter;

import java.util.List;


public interface  ChapterService extends IService<Chapter> {
    List<Chapter> findById(Integer id);
}