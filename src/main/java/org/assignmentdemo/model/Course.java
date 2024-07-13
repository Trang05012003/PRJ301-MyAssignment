package org.assignmentdemo.model;

public class Course {
    private int cid;
    private String cname;
    private int lid;
    private int subid;
    private int semid;

    public Course() {
    }

    public Course(int cid, String cname, int lid, int subid, int semid) {
        this.cid = cid;
        this.cname = cname;
        this.lid = lid;
        this.subid = subid;
        this.semid = semid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public int getSemid() {
        return semid;
    }

    public void setSemid(int semid) {
        this.semid = semid;
    }
}
