package com.project.pojo;

public class SanitationList {
     private String sanitation_scores_id;
     private String employee_id;
     private String dormitory_id;
     private String publish_time;
     private String score;

    @Override
    public String toString() {
        return "SanitationList{" +
                "sanitation_scores_id='" + sanitation_scores_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", dormitory_id='" + dormitory_id + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getSanitation_scores_id() {
        return sanitation_scores_id;
    }

    public void setSanitation_scores_id(String sanitation_scores_id) {
        this.sanitation_scores_id = sanitation_scores_id;
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

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
