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
    private String unit;
    private String teachname;
    private Integer is_boutique;
    private String schedule;

    public Courses(Integer id, String name, String type, String description, Integer like, String image, Integer p_id, String unit, String teachname, Integer is_boutique, String schedule) {
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
    }
}
