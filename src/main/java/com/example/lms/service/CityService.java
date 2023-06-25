package com.example.lms.service;

import com.example.lms.bean.City;
import com.example.lms.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City findById(Long id) {
        return cityMapper.findById(id);
    }

    public void insertCity(City city) {
        cityMapper.insertCity(city);
    }
}