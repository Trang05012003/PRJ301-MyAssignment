package org.assignmentdemo.model;

public class Grade {
    private int id;
    private int uid;
    private int aid;
    private float score;

    public Grade() {
    }

    public Grade(int id, int uid, int aid, float score) {
        this.id = id;
        this.uid = uid;
        this.aid = aid;
        this.score = score;
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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
