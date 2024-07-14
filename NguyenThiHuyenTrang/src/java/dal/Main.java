/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;

/**
 *
 * @author minhn
 */
public class Main {
    public static void main(String[] args) {
        UserContext userContext = new UserContext();
        User user = userContext.authenticateUser("lecturer", "lecturer");
        System.out.println(user.getName());
    }
}