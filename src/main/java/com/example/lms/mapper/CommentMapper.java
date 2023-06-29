package com.example.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lms.bean.Comment;
import com.example.lms.bean.Docs;
import com.example.lms.bean.Posts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date: 2023/6/29
 **/
public interface CommentMapper extends BaseMapper<Comment> {

    @Insert("insert into comment(u_name,c_id,createtime,is_delete,c_content) values (#{u_name},#{c_id},#{createtime},#{is_delete},#{c_content})")
    public Integer addCommentr(Comment comment);
    //通过id查询
    @Select("SELECT * FROM comment WHERE c_id = #{c_id}")
    List<Comment> findById(Integer c_id);
}
