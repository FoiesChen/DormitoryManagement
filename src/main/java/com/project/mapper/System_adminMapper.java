package com.project.mapper;

import com.project.pojo.System_adminList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface System_adminMapper {

    List<System_adminList> selectByid(String admin_id);

    void updateNameById(@Param("admin_id") String admin_id, @Param("name")String name);

    void updateemployee_idById(@Param("admin_id") String admin_id, @Param("employee_id")String employee_id);

    void updatecontactById(@Param("admin_id") String admin_id, @Param("contact_info")String contact_info);
}
