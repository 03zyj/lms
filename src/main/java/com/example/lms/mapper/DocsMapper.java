package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lms.bean.City;
import com.example.lms.bean.Docs;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date: 2023/6/28
 **/
public interface DocsMapper extends BaseMapper<Docs> {
    //查询全部
    @Select("SELECT * FROM docs")
    List<Docs> findAll();
    //通过id查询
    @Select("SELECT * FROM docs WHERE d_id = #{d_id}")
    Docs findById(Integer d_id);

}
