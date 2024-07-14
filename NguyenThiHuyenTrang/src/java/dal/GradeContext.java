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
import model.Grade;

public class GradeContext extends DBContext<Grade> {

    public GradeContext(){
        super();
    }
    @Override
    public void insert(Grade model) {
        try {
            String sql = "INSERT INTO grades (uid, aid, score) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getUid());
            statement.setInt(2, model.getAid());
            statement.setFloat(3, model.getScore());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradeContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Grade model) {
        try {
            String sql = "UPDATE grades SET uid = ?, aid = ?, score = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getUid());
            statement.setInt(2, model.getAid());
            statement.setFloat(3, model.getScore());
            statement.setInt(4, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradeContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Grade model) {
        try {
            String sql = "DELETE FROM grades WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradeContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Grade get(int id) {
        try {
            String sql = "SELECT * FROM grades WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Grade(rs.getInt("id"), rs.getInt("uid"), rs.getInt("aid"), rs.getFloat("score"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Grade> list() {
        ArrayList<Grade> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM grades";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Grade(rs.getInt("id"), rs.getInt("uid"), rs.getInt("aid"), rs.getFloat("score")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Grade getGradeByUserIdAndAssessmentId(int studentId, int assessmentId) {
        Grade grade = null;
        String sql = "SELECT * FROM grades WHERE uid = ? AND aid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, assessmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    grade = new Grade();
                    grade.setId(rs.getInt("id"));
                    grade.setUid(rs.getInt("uid"));
                    grade.setAid(rs.getInt("aid"));
                    grade.setScore(rs.getFloat("score"));
                    // You can set other properties if needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle better in production code
        }
        return grade;
    }
     public static void main(String[] args) {
        // Instantiate GradeContext
        GradeContext gradeContext = new GradeContext();

        // Test insert method
        Grade newGrade = gradeContext.getGradeByUserIdAndAssessmentId(2, 1);
         System.out.println(newGrade.getId());
        
        
    }
}

