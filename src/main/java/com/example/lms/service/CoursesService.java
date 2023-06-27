package com.example.lms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lms.bean.City;
import com.example.lms.bean.Courses;
import com.example.lms.bean.User;
import com.example.lms.mapper.CityMapper;
import com.example.lms.mapper.CoursesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface  CoursesService extends IService<Courses>{

    List<Courses> findAll();
}