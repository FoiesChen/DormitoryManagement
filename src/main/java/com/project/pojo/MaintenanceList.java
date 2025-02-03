package com.project.pojo;

public class MaintenanceList {

   private String maintenance_id;
   private String dormitory_building;
   private String name;
   private String contact_info;

    @Override
    public String toString() {
        return "MaintenanceList{" +
                "maintenance_id='" + maintenance_id + '\'' +
                ", dormitory_building='" + dormitory_building + '\'' +
                ", name='" + name + '\'' +
                ", contact_info='" + contact_info + '\'' +
                '}';
    }

    public String getMaintenance_man_id() {
        return maintenance_id;
    }

    public void setMaintenance_man_id(String maintenance_man_id) {
        this.maintenance_id = maintenance_man_id;
    }

    public String getDormitory_building() {
        return dormitory_building;
    }

    public void setDormitory_building(String dormitory_building) {
        this.dormitory_building = dormitory_building;
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
