package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semester;

public class SemesterContext extends DBContext<Semester> {

    @Override
    public void insert(Semester model) {
        try {
            String sql = "INSERT INTO semester (year) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getYear());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemesterContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Semester model) {
        try {
            String sql = "UPDATE semester SET year = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getYear());
            statement.setInt(2, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemesterContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Semester model) {
        try {
            String sql = "DELETE FROM semester WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemesterContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Semester get(int id) {
        try {
            String sql = "SELECT * FROM semester WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Semester(rs.getInt("id"), rs.getInt("year"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Semester> list() {
        ArrayList<Semester> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM semester";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Semester(rs.getInt("id"), rs.getInt("year")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
