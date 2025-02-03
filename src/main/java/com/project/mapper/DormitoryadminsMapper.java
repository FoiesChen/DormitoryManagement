package com.project.mapper;
import com.project.pojo.DormitoryadminsList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DormitoryadminsMapper {

    List<DormitoryadminsList> selectAll();

    List<DormitoryadminsList> selectById(String id);

    void updateDormitoryBuildingById(@Param("id") String id, @Param("dormitory_building")String dormitory_building);

    void updatefloorsById(@Param("id") String id, @Param("floors")String floors);

    void updateNameById(@Param("id") String id, @Param("name")String name);

    void updatecontact_infoById(@Param("id") String id, @Param("contact_info")String contact_info);
}
