package org.assignmentdemo.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DbContext<T> {
    protected Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Assignment_SU24";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Alopicasso1";

    public DbContext() {
        try {
//            SSMS: com.microsoft.sqlserver.jdbc.SQLServerDriver
//            mysql: com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract void insert(T model);

    public abstract void update(T model);

    public abstract void delete(T model);

    public abstract T get(int id);

    public abstract ArrayList<T> list();
}
