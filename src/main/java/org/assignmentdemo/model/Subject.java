package org.assignmentdemo.model;

public class Subject {
    private int subid;
    private String subname;

    public Subject() {
    }

    public Subject(int subid, String subname) {
        this.subid = subid;
        this.subname = subname;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
