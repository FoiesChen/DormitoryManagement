package com.project.mapper;
import com.project.pojo.SanitationList;

import java.util.List;

import org.apache.ibatis.annotations.Param;
public interface SanitationMapper {

    List<SanitationList> selectAll();

    List<SanitationList> selectById(String id);

    List<SanitationList> selectBydoId(String id);

    void newviolation(@Param("id") String id, @Param("employeeid")String employeeid,@Param("dormitoryid")String dormitoryid,@Param("publishtime")String publishtime,@Param("score")String score);

}
