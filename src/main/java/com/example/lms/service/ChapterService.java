package com.example.lms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lms.bean.Chapter;


public interface  ChapterService extends IService<Chapter> {
    Chapter findById(Integer id);
}