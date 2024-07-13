package org.assignmentdemo.service;

import org.assignmentdemo.db.DbContext;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
                System.out.println(students.size());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
