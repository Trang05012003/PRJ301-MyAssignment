package org.assignmentdemo.service;

import org.assignmentdemo.db.DbContext;
import org.assignmentdemo.model.Assessment;
import org.assignmentdemo.model.Grade;
import org.assignmentdemo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService extends DbContext<User> {
    public UserService() {
        super();
    }

    @Override
    public void insert(User model) {
        String sql = "INSERT INTO users (username, password, role, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, model.getUsername());
            stmt.setString(2, model.getPassword());
            stmt.setString(3, model.getRole());
            stmt.setString(4, model.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User model) {
        String sql = "UPDATE users SET username = ?, password = ?, role = ?, name = ? WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, model.getUsername());
            stmt.setString(2, model.getPassword());
            stmt.setString(3, model.getRole());
            stmt.setString(4, model.getName());
            stmt.setInt(5, model.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User model) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, model.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> list() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("name")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private User getByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User authenticateUser(String username, String password) {
        User user = this.getByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public ArrayList<User> getUsersByRole(String role) {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = ?";
        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, role);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    userList.add(new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role"),
                            rs.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public List<Grade> getGradesByStudentId(int studentId) {
        List<Grade> grades = new ArrayList<>();
        Connection connection = this.getConnection();
        try {
            String sql = "SELECT * FROM grades WHERE uid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setId(resultSet.getInt("id"));
                grade.setUid(resultSet.getInt("uid"));
                grade.setAid(resultSet.getInt("aid"));
                grade.setScore(resultSet.getFloat("score"));
                grades.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grades;
    }
}
