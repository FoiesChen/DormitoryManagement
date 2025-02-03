package com.project.mapper;

import com.project.pojo.studentList;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {

    List<studentList> selectAll();

    List<studentList> selectById(String id);

    List<studentList> findById(String id);

    void updateNameById(@Param("id") String id, @Param("name")String name);

    void updateMajorById(@Param("id") String id, @Param("major")String major);

    void updateDormitoryById(@Param("id") String id, @Param("dormitory")String dormitory);

    void updateDormitoryBuildingById(@Param("id") String id, @Param("dormitory_building")String dormitory_building);

    void deleteById(String id);
}
