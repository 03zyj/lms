package com.example.lms.mapper;


import com.example.lms.bean.VideoUpload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Mapper
public interface VideoUploadMapper {
    //插入数据到数据库内，目前需要把id加上，不会自动生成id，不然报错
    @Update("INSERT INTO `video`( `videoName`, `videoUrl`, `videoUUID`) VALUES (#{videoName},#{videoUrl},#{videoUUID});")
    //事务注解：可加可不加
    @Transactional
    //接收传过来的参数数据
    void save(String videoName,String videoUrl,String videoUUID);

    //查询数据库内表名为video_upload的全部数据返回
    @Select("select * from video")
    //方法：以数组的形式返回数据库信息
    List<VideoUpload> SelectVideoAll();


    //查询数据库内表名为video_upload的id=videoId的那一条数据
    @Select("select * from video where id = #{videoId}")
    //方法：以表格格式（就是数据库字段一样的格式直接返回一个对象里面包含各个字段和信息）返回
    VideoUpload SelectVideoId(Integer videoId);
}