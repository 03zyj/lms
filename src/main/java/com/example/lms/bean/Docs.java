package com.example.lms.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author
 * @date: 2023/6/28
 **/
@Data
public class Docs {
    private Integer d_id;
    private String d_name;
    private String d_synopsis;
    private String d_author;
    private String d_img;

    public Docs(Integer d_id, String d_name, String d_synopsis, String d_author, String d_img) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_synopsis = d_synopsis;
        this.d_author = d_author;
        this.d_img = d_img;
    }
}
