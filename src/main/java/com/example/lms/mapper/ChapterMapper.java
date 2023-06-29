package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lms.bean.Chapter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {
    @Select("SELECT s.id,s.name as sname,s.sort as so,s.url,ch.cid,ch.`name` as chname,ch.sort as cho FROM `subsection` as s left JOIN chapter as ch on  s.chid=ch.id\n" +
            "LEFT JOIN courses as c on ch.cid=c.id where cid=#{id}")
    List<Chapter> findById(Integer id);
}
