package com.example.lms.controller;

import com.example.lms.bean.Docs;
import com.example.lms.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
@Controller
public class DocsController {
    @Autowired
    DocsService docsService;

    @GetMapping("/docs")
    String docs(Model model) {
        List<Docs> docsList = docsService.findAll();
        model.addAttribute("docsList", docsList);
        return "docs";
    }

    @GetMapping("/docs_show/{id}")
    public String showDocs(@PathVariable("id") Integer id, Model model) {
        // 根据id从数据库或其他数据源获取相应的文档信息
        Docs docs = docsService.findById(id);
        // System.out.println("docs"+docs);
        // 将文档信息添加到Model中，供视图层使用
        model.addAttribute("docsList", docs);
        // 返回视图名，视图名通常对应于模板引擎中的模板文件名
        return "docs-show";
    }

}
