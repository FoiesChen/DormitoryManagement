package com.project.pojo;

public class AnnouncementsList {
  private String announcement_id;
  private String title;
  private String content;
  private String publish_time;
  private String employee_id;

    @Override
    public String toString() {
        return "AnnouncementsList{" +
                "announcement_id='" + announcement_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", employee_id='" + employee_id + '\'' +
                '}';
    }

    public String getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(String announcement_id) {
        this.announcement_id = announcement_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
