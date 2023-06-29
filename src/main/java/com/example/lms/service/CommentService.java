package com.example.lms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lms.bean.Comment;
import com.example.lms.bean.Docs;
import com.example.lms.bean.Posts;

import java.util.List;

/**
 * @author
 * @date: 2023/6/29
 **/
public interface CommentService extends IService<Comment> {
    //添加评论
    public boolean addComment(Comment comment);
    //通过id查询
    List<Comment> findById(Integer c_id);
}
