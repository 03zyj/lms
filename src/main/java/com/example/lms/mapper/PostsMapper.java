package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.lms.bean.Docs;
import com.example.lms.bean.Posts;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
public interface PostsMapper extends BaseMapper<Posts> {
    //查询全部
    @Select("SELECT * FROM courses")
    List<Posts> findAll();
    //通过id查询
    @Select("SELECT * FROM courses WHERE id = #{id}")
    Posts findById(Integer id);
    //通过id查询
    @Select("SELECT * FROM courses WHERE pp_id = #{pp_id}")
    Posts findById1(Integer pp_id);

}
