package com.example.lms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lms.bean.Courses;
import com.example.lms.bean.Docs;
import com.example.lms.mapper.CoursesMapper;
import com.example.lms.mapper.DocsMapper;
import com.example.lms.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
@Service
public class DocsServiceImpl extends ServiceImpl<DocsMapper, Docs> implements DocsService {
    @Autowired
    DocsMapper docsMapper;
    @Override
    public List<Docs> findAll() {
        List<Docs> list = docsMapper.findAll();
        // System.out.println("list=="+list);
        return list;
    }

    @Override
    public Docs findById(Integer d_id) {
        Docs docs = docsMapper.findById(d_id);
        return docs;
    }
}
