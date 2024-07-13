package org.assignmentdemo.service;

import org.assignmentdemo.db.DbContext;
import org.assignmentdemo.model.Assessment;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.model.Grade;
import org.assignmentdemo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CourseService extends DbContext<Course> {
    public CourseService() {
        super();
    }

    @Override
    public void insert(Course model) {
        String sql = "INSERT INTO courses (name, semid) VALUES (?, ?)";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, model.getName());
            stmt.setInt(2, model.getSemid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Course model) {
        String sql = "UPDATE courses SET name = ?, semid = ? WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, model.getName());
            stmt.setInt(2, model.getSemid());
            stmt.setInt(3, model.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course model) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, model.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course get(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Course(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("semid")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Course> list() {
        ArrayList<Course> courseList = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("semid")
                );
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public ArrayList<Course> getCoursesByLecturerId(int lecturerId) {
        HashMap<Integer, Course> hashMap = new HashMap<>();
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "SELECT c.id, c.name, c.semid " +
                "FROM users_courses uc " +
                "JOIN courses c ON uc.courseId = c.id " +
                "WHERE uc.lid = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, lecturerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Course course = new Course(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("semid")
                    );
                    hashMap.put(rs.getInt("id"), course);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        courses.addAll(hashMap.values());

        return courses;
    }

    public ArrayList<User> getStudentsByLecturerAndCourse(int lecturerId, int courseId) {
        ArrayList<User> students = new ArrayList<>();
        String sql = "SELECT u.id, u.username, u.name, u.role, uc.active, u.password " +
                "FROM users u " +
                "JOIN users_courses uc ON u.id = uc.uid " +
                "WHERE uc.lid = ? AND uc.courseId = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, lecturerId);
            stmt.setInt(2, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    boolean active = rs.getBoolean("active");
                    students.add(new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getString("name"),
                            active
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Grade> getGradesByUserIdAndCourseId(int userId, int courseId) {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT g.id, g.uid, g.aid, g.score " +
                "FROM users_courses uc " +
                "JOIN grades g ON uc.uid = g.uid " +
                "WHERE uc.uid = ? AND uc.courseId = ?";

        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, courseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setId(resultSet.getInt("id"));
                grade.setUid(resultSet.getInt("uid"));
                grade.setAid(resultSet.getInt("aid"));
                grade.setScore(resultSet.getFloat("score"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public List<Assessment> getAssessments() {
        List<Assessment> assessments = new ArrayList<>();
        Connection connection = this.getConnection();
        try {
            String sql = "SELECT * FROM assessments";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Assessment assessment = new Assessment();
                assessment.setId(resultSet.getInt("id"));
                assessment.setName(resultSet.getString("name"));
                assessment.setWeight(resultSet.getFloat("weight"));
                assessments.add(assessment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return assessments;
    }

    public ArrayList<Course> getCoursesByStudentId(int studentId) {
        ArrayList<Course> courses = new ArrayList<>();
        Connection connection = this.getConnection();
        try {
            String sql = "SELECT c.id, c.name, c.semid FROM courses c " +
                    "JOIN users_courses uc ON c.id = uc.courseId " +
                    "WHERE uc.uid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setSemid(resultSet.getInt("semid"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
