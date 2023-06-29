package com.example.lms.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author
 * @date: 2023/6/28
 **/
@Data
public class Comment {
    private Integer id;
    private String u_name;
    private Integer c_id;
    private String createtime;
    private Integer is_delete;
    private String image;
    private String c_content;

    public Comment(Integer id, String u_name, Integer c_id, String createtime, Integer is_delete, String image, String c_content) {
        this.id = id;
        this.u_name = u_name;
        this.c_id = c_id;
        this.createtime = createtime;
        this.is_delete = is_delete;
        this.image = image;
        this.c_content = c_content;
    }
}
