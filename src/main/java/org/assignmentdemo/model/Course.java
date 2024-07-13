package org.assignmentdemo.model;

public class Course {
    private int id;
    private String name;
    private int semid;

    public Course() {
    }

    public Course(int id, String name, int semid) {
        this.id = id;
        this.name = name;
        this.semid = semid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemid() {
        return semid;
    }

    public void setSemid(int semid) {
        this.semid = semid;
    }
}
