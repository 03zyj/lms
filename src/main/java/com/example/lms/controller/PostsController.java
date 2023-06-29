package com.example.lms.controller;

import com.example.lms.bean.Docs;
import com.example.lms.bean.Posts;
import com.example.lms.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
@Controller
public class PostsController {
    @Autowired
    PostsService postsService;

    @GetMapping("/posts")
    String posts(Model model) {
        List<Posts> postsList = postsService.findAll();
//        System.out.println("postsList=="+postsList);
        model.addAttribute("postsList", postsList);
        return "posts";
    }

    @GetMapping("/posts_show/{id}")
    String posts_show(@PathVariable("id") Integer id, Model model) {
        // 根据id从数据库或其他数据源获取相应的文档信息
        Posts posts = postsService.findById(id);

        // System.out.println("posts"+posts);
        // 将文档信息添加到Model中，供视图层使用
        model.addAttribute("postsList", posts);
        // 返回视图名，视图名通常对应于模板引擎中的模板文件名
        return "posts-show";
    }

    @GetMapping("/posts_show12/{id}")
    String posts_show12(@PathVariable("id") Integer id, Model model) {
        // 根据id从数据库或其他数据源获取相应的文档信息
        Posts posts = postsService.findById(id);

        // System.out.println("posts"+posts);
        // 将文档信息添加到Model中，供视图层使用
        model.addAttribute("postsList", posts);
        // 返回视图名，视图名通常对应于模板引擎中的模板文件名
        return "posts-show12";
    }

}
