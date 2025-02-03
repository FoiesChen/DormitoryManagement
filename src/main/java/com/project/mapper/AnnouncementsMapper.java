package com.project.mapper;
import com.project.pojo.AnnouncementsList;

import java.util.List;

import com.project.pojo.DormitoryadminsList;
import org.apache.ibatis.annotations.Param;
public interface AnnouncementsMapper {

    List<AnnouncementsList> selectAll();

    List<AnnouncementsList> selectById(String id);

    void updatetitleById(@Param("id") String id, @Param("title")String title);

    void updatecontentById(@Param("id") String id, @Param("content")String content);

    void newannouncement(@Param("id") String id, @Param("title")String title,@Param("content")String content,@Param("publish_time")String publish_time,@Param("employeeid")String employeeid);
}
