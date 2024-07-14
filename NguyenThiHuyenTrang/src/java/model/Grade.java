/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author X1 Nano
 */
public class Grade {
    private int id;
    private int uid;
    private int aid;
    private float score;
    private int courseId;
    // Constructor
    public Grade(int id, int uid, int aid, float score) {
        this.id = id;
        this.uid = uid;
        this.aid = aid;
        this.score = score;
    }

    public Grade(int uid, int aid, float score, int courseId) {
        this.uid = uid;
        this.aid = aid;
        this.score = score;
        this.courseId = courseId;
    }

    public Grade( int uid, int aid, float score) {
        this.uid = uid;
        this.aid = aid;
        this.score = score;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Grade() {
       
    }

    // Getters and Setters
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

