package com.example.lms.service.impl;
import com.example.lms.bean.Courses;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lms.mapper.CoursesMapper;
import com.example.lms.service.CoursesService;
import org.springframework.stereotype.Service;

@Service
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses> implements CoursesService {
}
