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
import model.Assessment;

public class AssessmentContext extends DBContext<Assessment> {

    @Override
    public void insert(Assessment model) {
        try {
            String sql = "INSERT INTO assessments (name, weight) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getName());
            statement.setFloat(2, model.getWeight());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Assessment model) {
        try {
            String sql = "UPDATE assessments SET name = ?, weight = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getName());
            statement.setFloat(2, model.getWeight());
            statement.setInt(3, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Assessment model) {
        try {
            String sql = "DELETE FROM assessments WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Assessment get(int id) {
        try {
            String sql = "SELECT * FROM assessments WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Assessment(rs.getInt("id"), rs.getString("name"), rs.getFloat("weight"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Assessment> list() {
        ArrayList<Assessment> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM assessments";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Assessment(rs.getInt("id"), rs.getString("name"), rs.getFloat("weight")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

