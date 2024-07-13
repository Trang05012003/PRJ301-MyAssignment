package org.assignmentdemo.model;

public class Assessment {
    private int id;
    private String name;
    private float weight;
    private Grade grade;

    public Assessment() {
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Assessment(int id, String name, float weight, Grade grade) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.grade = grade;
    }

    public Assessment(int id, String name, float weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
