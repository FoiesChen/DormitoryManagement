package com.project.pojo;

public class System_adminList {

   private String admin_id;
   private String employee_id;
   private String name;
   private String contact_info;

    @Override
    public String toString() {
        return "System_adminList{" +
                "admin_id='" + admin_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", name='" + name + '\'' +
                ", contact_info='" + contact_info + '\'' +
                '}';
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
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
