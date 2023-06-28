package com.example.lms.service.impl;
import com.example.lms.bean.City;
import com.example.lms.bean.Courses;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lms.mapper.CityMapper;
import com.example.lms.mapper.CoursesMapper;
import com.example.lms.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses> implements CoursesService {
    @Autowired
    CoursesMapper coursesMapper;

    @Override
    public List<Courses> findAll() {
        List<Courses> list = coursesMapper.findAll();
        return list;
    }

    public Courses findById(Integer id) {
        return coursesMapper.findById(id);
    }
}
