package org.assignmentdemo.dal;

import org.assignmentdemo.model.Assessment;
import org.assignmentdemo.model.Exam;
import org.assignmentdemo.model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamDbContext extends DbContext<Exam> {
    public ArrayList<Exam> getExamsByCourse(int cid) {
        ArrayList<Exam> exams = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT e.eid,e.duration,e.[from],a.aid,a.aname,a.weight,sub.subid,sub.subname FROM exams e INNER JOIN assesments a ON a.aid = e.aid\n" + "			INNER JOIN subjects sub ON sub.subid = a.subid\n" + "			INNER JOIN courses c ON c.subid = sub.subid\n" + "			WHERE c.cid = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Exam e = new Exam();
                e.setId(rs.getInt("eid"));
                e.setDuration(rs.getInt("duration"));
                e.setFrom(rs.getTimestamp("from"));

                Assessment a = new Assessment();
                a.setId(rs.getInt("aid"));
                a.setName(rs.getString("aname"));
                a.setWeight(rs.getFloat("weight"));

                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                a.setSubject(sub);

                e.setAssessment(a);
                exams.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDbContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ExamDbContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exams;
    }

    public ArrayList<Exam> getExamsByExamIds(ArrayList<Integer> eids) {
        ArrayList<Exam> exams = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT e.eid,e.[from],a.aid,a.aname,a.weight FROM exams e INNER JOIN assesments a ON a.aid = e.aid\n" + "						WHERE (1>2)";

            for (Integer eid : eids) {
                sql += " OR eid = ?";
            }

            stm = connection.prepareStatement(sql);

            for (int i = 0; i < eids.size(); i++) {
                stm.setInt((i + 1), eids.get(i));
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Exam e = new Exam();
                e.setId(rs.getInt("eid"));
                e.setFrom(rs.getTimestamp("from"));

                Assessment a = new Assessment();
                a.setId(rs.getInt("aid"));
                a.setName(rs.getString("aname"));
                a.setWeight(rs.getFloat("weight"));

                e.setAssessment(a);
                exams.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDbContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ExamDbContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exams;
    }

    @Override
    public void insert(Exam model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Exam model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Exam model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Exam get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Exam> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
