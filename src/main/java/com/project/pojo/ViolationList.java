package com.project.pojo;

public class ViolationList {
  private String violation_record_id;

  private String employee_id;

  private String dormitory_id;

  private String violation_time;

  private String violation_content;

    @Override
    public String toString() {
        return "violationList{" +
                "violation_record_id='" + violation_record_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", dormitory_id='" + dormitory_id + '\'' +
                ", violation_time='" + violation_time + '\'' +
                ", violation_content='" + violation_content + '\'' +
                '}';
    }

    public String getViolation_record_id() {
        return violation_record_id;
    }

    public void setViolation_record_id(String violation_record_id) {
        this.violation_record_id = violation_record_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDormitory_id() {
        return dormitory_id;
    }

    public void setDormitory_id(String dormitory_id) {
        this.dormitory_id = dormitory_id;
    }

    public String getViolation_time() {
        return violation_time;
    }

    public void setViolation_time(String violation_time) {
        this.violation_time = violation_time;
    }

    public String getViolation_content() {
        return violation_content;
    }

    public void setViolation_content(String violation_content) {
        this.violation_content = violation_content;
    }
}
