package com.example.lms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.lms.bean.Docs;
import com.example.lms.bean.Posts;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
public interface PostsService extends IService<Posts> {
    //查询全部
    List<Posts> findAll();
    //通过id查询
    Posts findById(Integer id);
    //通过id查询
    Posts findById1(Integer pp_id);
}
