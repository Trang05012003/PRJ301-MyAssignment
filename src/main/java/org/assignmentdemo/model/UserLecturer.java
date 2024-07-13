package org.assignmentdemo.model;

public class UserLecturer {
    private int lecturer_id;
    private int student_id;

    public UserLecturer() {
    }

    public UserLecturer(int lecturer_id, int student_id) {
        this.lecturer_id = lecturer_id;
        this.student_id = student_id;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
