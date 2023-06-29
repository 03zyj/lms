package com.example.lms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lms.bean.Docs;
import com.example.lms.bean.Posts;
import com.example.lms.mapper.DocsMapper;
import com.example.lms.mapper.PostsMapper;
import com.example.lms.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements PostsService {
    @Autowired
    PostsMapper postsMapper;

    @Override
    public List<Posts> findAll() {
        List<Posts> postsList = postsMapper.findAll();
        return postsList;
    }

    @Override
    public Posts findById(Integer id) {
        Posts posts = postsMapper.findById(id);
        return posts;
    }

    @Override
    public Posts findById1(Integer pp_id) {
        Posts posts = postsMapper.findById1(pp_id);
        return posts;
    }
}
