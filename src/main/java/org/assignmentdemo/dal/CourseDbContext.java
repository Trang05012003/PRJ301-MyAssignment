package org.assignmentdemo.dal;

import org.assignmentdemo.model.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDbContext extends DbContext<Course> {
    public ArrayList<Course> getCoursesByLecturer(int lid) {
        ArrayList<Course> courses = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT c.cid,c.cname FROM courses c INNER JOIN lecturers l ON l.lid = c.lid\n"
                    + "				INNER JOIN semester sem ON sem.semid = c.semid\n"
                    + "				WHERE l.lid = ? AND sem.active = 1";


            stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                courses.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDbContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDbContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return courses;


    }

    @Override
    public void insert(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Course get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Course> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
