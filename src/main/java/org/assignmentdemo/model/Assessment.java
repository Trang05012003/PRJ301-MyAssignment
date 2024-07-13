package org.assignmentdemo.model;

public class Assessment {
    private int aid;
    private String aname;
    private float weight;
    private Integer subid;

    public Assessment() {
    }

    public Assessment(int aid, String aname, float weight, Integer subid) {
        this.aid = aid;
        this.aname = aname;
        this.weight = weight;
        this.subid = subid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        this.subid = subid;
    }
}
