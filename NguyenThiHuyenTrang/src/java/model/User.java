/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sonnt-local
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String name;
    private boolean activeCourse = false;

    public boolean getActiveCourse() {
        return activeCourse;
    }

    // Constructor

    public User(int id, String username, String password, String role, String name, boolean activeCourse) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.activeCourse = activeCourse;
    }
     public User(int id, String username, String password, String role, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
    }
    public boolean isActiveCourse() {
        return activeCourse;
    }

    public void setActiveCourse(boolean activeCourse) {
        this.activeCourse = activeCourse;
    }
    

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

