/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author minhn
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UsersCourses;

public class UsersCoursesContext extends DBContext<UsersCourses> {

    @Override
    public void insert(UsersCourses model) {
        try {
            String sql = "INSERT INTO users_courses (uid, courseId, active) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getUid());
            statement.setInt(2, model.getCourseId());
            statement.setBoolean(3, model.isActive());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersCoursesContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(UsersCourses model) {
        try {
            String sql = "UPDATE users_courses SET uid = ?, courseId = ?, active = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getUid());
            statement.setInt(2, model.getCourseId());
            statement.setBoolean(3, model.isActive());
            statement.setInt(4, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersCoursesContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(UsersCourses model) {
        try {
            String sql = "DELETE FROM users_courses WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersCoursesContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public UsersCourses get(int id) {
        try {
            String sql = "SELECT * FROM users_courses WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new UsersCourses(rs.getInt("id"), rs.getInt("uid"), rs.getInt("courseId"), rs.getBoolean("active"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersCoursesContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<UsersCourses> list() {
        ArrayList<UsersCourses> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users_courses";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new UsersCourses(rs.getInt("id"), rs.getInt("uid"), rs.getInt("courseId"), rs.getBoolean("active")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersCoursesContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

