package org.assignmentdemo.dal;

import org.assignmentdemo.model.Exam;
import org.assignmentdemo.model.Grade;
import org.assignmentdemo.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GradeDbContext extends DbContext<Grade> {
    public ArrayList<Grade> getGradesFromExamIds(ArrayList<Integer> eids) {
        ArrayList<Grade> grades = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT eid,sid,score FROM grades WHERE (1>2)";
            for (Integer eid : eids) {
                sql += " OR eid = ?";
            }

            stm = connection.prepareStatement(sql);

            for (int i = 0; i < eids.size(); i++) {
                stm.setInt((i + 1), eids.get(i));
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                g.setScore(rs.getFloat("score"));

                Student s = new Student();
                s.setId(rs.getInt("sid"));
                g.setStudent(s);

                Exam e = new Exam();
                e.setId(rs.getInt("eid"));
                g.setExam(e);

                grades.add(g);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GradeDbContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradeDbContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return grades;
    }

    public void insertGradesForCourse(int cid, ArrayList<Grade> grades) {
        String sql_remove = "DELETE grades WHERE sid IN (SELECT sid FROM students_courses WHERE cid = ?)";
        String sql_insert = "INSERT INTO [grades]\n"
                + "           ([eid]\n"
                + "           ,[sid]\n"
                + "           ,[score])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";

        PreparedStatement stm_remove = null;
        ArrayList<PreparedStatement> stm_inserts = new ArrayList<>();

        try {
            connection.setAutoCommit(false);
            stm_remove = connection.prepareStatement(sql_remove);
            stm_remove.setInt(1, cid);
            stm_remove.executeUpdate();

            for (Grade grade : grades) {
                PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
                stm_insert.setInt(1, grade.getExam().getId());
                stm_insert.setInt(2, grade.getStudent().getId());
                stm_insert.setFloat(3, grade.getScore());
                stm_insert.executeUpdate();
                stm_inserts.add(stm_insert);
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(GradeDbContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(GradeDbContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                stm_remove.close();
                for (PreparedStatement stm_insert : stm_inserts) {
                    stm_insert.close();
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradeDbContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void insert(Grade model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Grade model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Grade model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Grade get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Grade> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
