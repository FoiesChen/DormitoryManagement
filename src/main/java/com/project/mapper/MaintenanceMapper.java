package com.project.mapper;

import com.project.pojo.MaintenanceList;

import java.util.List;

public interface MaintenanceMapper {

    List<MaintenanceList> selectBydormitory_building(String id);

}
