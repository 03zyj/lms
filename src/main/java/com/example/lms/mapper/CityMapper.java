package com.example.lms.mapper;

import com.example.lms.bean.City;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {
    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City findById(long id);

    /*@Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")*/
    void insertCity(City city);
}
