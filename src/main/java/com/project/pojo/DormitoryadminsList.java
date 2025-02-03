package com.project.pojo;

public class DormitoryadminsList {
   private String employee_id;
   private String dormitory_building;
   private String floors ;
   private String name;
   private String contact_info;

    @Override
    public String toString() {
        return "DormitoryadminsList{" +
                "employee_id='" + employee_id + '\'' +
                ", dormitory_building='" + dormitory_building + '\'' +
                ", floors='" + floors + '\'' +
                ", name='" + name + '\'' +
                ", contact_info='" + contact_info + '\'' +
                '}';
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDormitory_building() {
        return dormitory_building;
    }

    public void setDormitory_building(String dormitory_building) {
        this.dormitory_building = dormitory_building;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }
}
