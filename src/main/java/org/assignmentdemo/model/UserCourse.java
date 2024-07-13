package org.assignmentdemo.model;

public class UserCourse {
    private int id;
    private int uid;
    private int courseId;
    private boolean active;

    public UserCourse() {
    }

    public UserCourse(int id, int uid, int courseId, boolean active) {
        this.id = id;
        this.uid = uid;
        this.courseId = courseId;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
