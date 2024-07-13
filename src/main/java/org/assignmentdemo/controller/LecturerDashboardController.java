package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LecturerDashboardController", urlPatterns = "/lecturer/dashboard")
public class LecturerDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/lecturer/dashboard.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Lecturer Dashboard Controller";
    }
}
