package com.example.lms.controller;

import com.example.lms.bean.Comment;
import com.example.lms.bean.Posts;
import com.example.lms.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date: 2023/6/29
 **/
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    //添加评论
    @PostMapping("/addComment")
    @ResponseBody
    public Map<String, Object> addComment(Comment comment,
                                          @RequestParam("commentContent") String commentContent,
                                          @RequestParam("username") String username,
                                          @RequestParam("cname") Integer cname
                                         ){
        Map<String, Object> result = new HashMap<>();

        //获取时间
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        comment.setCreatetime(formattedDate);

        comment.setIs_delete(0);
        comment.setU_name(username);
        comment.setC_content(commentContent);
        comment.setC_id(cname);

        System.out.println("comment===="+comment);


        //调用service保存评论信息
        boolean success = commentService.addComment(comment);
        if (success) {
            result.put("success", true);
            result.put("msg", "评论成功");
            result.put("redirectUrl", "/posts");
            return result;
        } else {
            result.put("success", false);
            result.put("msg", "评论失败，请稍后再试");
            return result;
                }
            }
       //查询评论
       @GetMapping("/comment_show/{id}")
       String posts_show(@PathVariable("id") Integer id, Model model) {
           // 根据id从数据库或其他数据源获取相应的文档信息
           List<Comment> commentList = commentService.findById(id);
           // System.out.println("comment_show=="+commentList);
           // System.out.println("posts"+posts);
           // 将文档信息添加到Model中，供视图层使用
           model.addAttribute("commentList12", commentList);
           // 返回视图名，视图名通常对应于模板引擎中的模板文件名
           return "comment_show";
       }

}
