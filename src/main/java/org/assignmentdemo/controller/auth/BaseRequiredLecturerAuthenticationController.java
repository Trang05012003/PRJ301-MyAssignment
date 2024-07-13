package org.assignmentdemo.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.model.Lecturer;
import org.assignmentdemo.model.User;

import java.io.IOException;

public abstract class BaseRequiredLecturerAuthenticationController extends HttpServlet {
    private boolean isAuthenticated(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            return false;
        else {
            Lecturer lecturer = user.getLecturer();
            return lecturer != null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (isAuthenticated(request)) {
            doGet(request, response, user, user.getLecturer());
        } else {
            response.getWriter().println("access denied!");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, User user, Lecturer lecturer)
            throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, User user, Lecturer lecturer)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (isAuthenticated(request)) {
            doPost(request, response, user, user.getLecturer());
        } else {
            response.getWriter().println("access denied!");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
