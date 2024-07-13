package org.assignmentdemo.model;

public class Grade {
    private int id;
    private int uid;
    private int aid;
    private float score;
    private Assessment assessment;

    public Grade() {
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Grade(int id, int uid, int aid, float score, Assessment assessment) {
        this.id = id;
        this.uid = uid;
        this.aid = aid;
        this.score = score;
        this.assessment = assessment;
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
