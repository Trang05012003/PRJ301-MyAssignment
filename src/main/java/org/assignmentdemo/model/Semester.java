package org.assignmentdemo.model;

public class Semester {
    private int semid;
    private int year;

    public Semester() {
    }

    public Semester(int semid, int year) {
        this.semid = semid;
        this.year = year;
    }

    public int getSemid() {
        return semid;
    }

    public void setSemid(int semid) {
        this.semid = semid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
