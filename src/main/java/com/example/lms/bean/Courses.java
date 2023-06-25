package com.example.lms.bean;

import lombok.Data;

@Data
public class Courses {
    private Integer id;
    private String name;
    private String type;
    private String description;
    private Integer like;
    private String image;
    private Integer p_id;

    public Courses(Integer id, String name, String type, String description, Integer like, String image, Integer p_id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.like = like;
        this.image = image;
        this.p_id = p_id;
    }

}
