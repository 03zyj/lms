package com.example.lms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.lms.bean.Docs;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
public interface DocsService extends IService<Docs> {
    //查询全部
    List<Docs> findAll();
    //通过id查询
    Docs findById(Integer d_id);
}
