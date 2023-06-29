package com.example.lms.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author
 * @date: 2023/6/28
 **/
@Data
public class Posts {
    private Integer id;
    private String name;
    private String type;
    private String description;
    private Integer like;
    private String image;
    private Integer p_id;
    private String unit;
    private String teachname;
    private Integer is_boutique;
    private String schedule;

    private Integer pp_id;
    private String p_name;
    private String p_author;
    private Date p_date;
    private String p_img;
    private String p_content;

    public Posts(Integer id, String name, String type, String description, Integer like, String image, Integer p_id, String unit, String teachname, Integer is_boutique, String schedule, Integer pp_id, String p_name, String p_author, Date p_date, String p_img, String p_content) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.like = like;
        this.image = image;
        this.p_id = p_id;
        this.unit = unit;
        this.teachname = teachname;
        this.is_boutique = is_boutique;
        this.schedule = schedule;
        this.pp_id = pp_id;
        this.p_name = p_name;
        this.p_author = p_author;
        this.p_date = p_date;
        this.p_img = p_img;
        this.p_content = p_content;
    }
}
