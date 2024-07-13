package org.assignmentdemo.model;

public class Semester {
    private int id;
    private int year;

    public Semester() {
    }

    public Semester(int id, int year) {
        this.id = id;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
