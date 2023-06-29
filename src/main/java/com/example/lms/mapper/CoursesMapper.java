package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lms.bean.City;
import com.example.lms.bean.Courses;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CoursesMapper extends BaseMapper<Courses> {
    @Select("SELECT * FROM courses")
    List<Courses> findAll();
    @Select("SELECT * FROM courses WHERE id = #{id}")
    Courses findById(Integer id);
    @Select("SELECT * FROM courses where name like concat('%',#{name},'%') order by courses.`like` desc limit 1")
    Courses findByName(String name);
    @Update("UPDATE courses\n" +
            "SET ispay = 2\n" +
            "WHERE id = #{id} ")
    int updatePay(Integer id);
    @Delete("delete from courses where id =  #{id}")
    int delete(Integer id);
}
