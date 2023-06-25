package com.example.lms.controller;

import com.example.lms.bean.City;
import com.example.lms.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/city/{id}")
    public City findById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PostMapping("/city")
    public City insertCity(City city) {
        cityService.insertCity(city);
        return city;
    }
}
