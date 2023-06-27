package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lms.bean.Courses;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CoursesMapper extends BaseMapper<Courses> {
    @Select("SELECT * FROM courses")
    List<Courses> findAll();
}
