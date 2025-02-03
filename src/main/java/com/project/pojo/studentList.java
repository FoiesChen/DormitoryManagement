package com.project.pojo;

public class studentList {

   private String studentID;
   private String name;
   private String gender;
   private String enrollment_date;
   private String major;
   private String dormitory_building;
   private String dormitory;

    @Override
    public String toString() {
        return "student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", enrollment_date='" + enrollment_date + '\'' +
                ", major='" + major + '\'' +
                ", dormitory_building='" + dormitory_building + '\'' +
                ", dormitory='" + dormitory + '\'' +
                '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(String enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDormitory_building() {
        return dormitory_building;
    }

    public void setDormitory_building(String dormitory_building) {
        this.dormitory_building = dormitory_building;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }
}
