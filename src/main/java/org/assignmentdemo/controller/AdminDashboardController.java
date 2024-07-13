package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.model.User;
import org.assignmentdemo.service.UserService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminDashboardController", urlPatterns = "/admin/dashboard/*")
public class AdminDashboardController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        switch (path) {
            case "/admin/dashboard": {
                request.getRequestDispatcher("/view/admin/dashboard.jsp").forward(request, response);
                break;
            }
            case "/admin/dashboard/lecturers": {
                ArrayList<User> lecturers = this.userService.getUsersByRole("lecturer");
                request.setAttribute("lecturers", lecturers);
                request.getRequestDispatcher("/view/admin/list_lecturers.jsp").forward(request, response);
                break;
            }
            case "/admin/dashboard/students": {
                ArrayList<User> students = this.userService.getUsersByRole("student");
                request.setAttribute("role", "admin");
                request.setAttribute("students", students);
                request.getRequestDispatcher("/view/admin/list_students.jsp").forward(request, response);
                break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Lecturer Dashboard Controller";
    }
}
