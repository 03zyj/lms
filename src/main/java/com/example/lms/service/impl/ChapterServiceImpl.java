package com.example.lms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lms.bean.Chapter;
import com.example.lms.mapper.ChapterMapper;
import com.example.lms.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper,Chapter> implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;


    public List<Chapter> findById(Integer id) {
        return chapterMapper.findById(id);
    }
}
