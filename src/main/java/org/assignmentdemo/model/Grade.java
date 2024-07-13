package org.assignmentdemo.model;

public class Grade {
    private int eid;
    private int sid;
    private float score;

    public Grade() {
    }

    public Grade(int eid, int sid, float score) {
        this.eid = eid;
        this.sid = sid;
        this.score = score;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
