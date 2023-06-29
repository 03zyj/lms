package com.example.lms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lms.bean.Comment;
import com.example.lms.bean.Docs;
import com.example.lms.mapper.CommentMapper;
import com.example.lms.mapper.DocsMapper;
import com.example.lms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date: 2023/6/29
 **/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean addComment(Comment comment) {
        //新增评论
        int result = commentMapper.addCommentr(comment);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    //通过id查询
    @Override
    public List<Comment> findById(Integer c_id) {
        List<Comment> list = commentMapper.findById(c_id);
        // System.out.println("list=="+list);
        return list;
    }


}
