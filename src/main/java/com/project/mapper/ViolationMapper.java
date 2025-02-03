package com.project.mapper;
import com.project.pojo.ViolationList;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ViolationMapper {

    List<ViolationList> selectAll();

    List<ViolationList> selectById(String id);

    List<ViolationList> selectBydoId(String id);

    void newviolation(@Param("id") String id, @Param("employeeid")String employeeid,@Param("dormitoryid")String dormitoryid,@Param("violation_time")String violation_time,@Param("violationcontent")String violationcontent);


}
