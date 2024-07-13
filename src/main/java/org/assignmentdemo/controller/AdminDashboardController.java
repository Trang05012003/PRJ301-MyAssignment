package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminDashboardController", urlPatterns = "/admin/dashboard/*")
public class AdminDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        switch (path) {
            case "/admin/dashboard": {
                request.getRequestDispatcher("/view/admin/dashboard.jsp").forward(request, response);
                break;
            }
            case "/admin/dashboard/lectures": {
                break;
            }
            case "/admin/dashboard/students": {
                break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Lecturer Dashboard Controller";
    }
}
