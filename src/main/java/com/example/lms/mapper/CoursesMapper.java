package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lms.bean.Courses;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CoursesMapper extends BaseMapper<Courses> {
    @Select("SELECT * FROM courses")
    List<Courses> findAll();
    @Select("SELECT * FROM courses WHERE id = #{id}")
    Courses findById(Integer id);
    @Select("SELECT * FROM courses WHERE name = #{name}")
    Courses findByName(String name);
    @Update("UPDATE courses\n" +
            "SET ispay = 2\n" +
            "WHERE id = #{id} ")
    int updatePay(Integer id);
}
