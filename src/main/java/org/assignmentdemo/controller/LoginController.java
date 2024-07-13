package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.assignmentdemo.model.User;
import org.assignmentdemo.service.UserService;

import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = this.userService.authenticateUser(username, password);

        if (user == null) {
            resp.sendRedirect("/login?error=invalid_credentials");
        }

        HttpSession session = req.getSession();
        session.setAttribute("loggedInUser", true);
        session.setAttribute("role", user.getRole());

        if ("lecturer".equals(user.getRole())) {
            resp.sendRedirect("/lecturer/dashboard");
        } else if ("student".equals(user.getRole())) {
            resp.sendRedirect("/student/dashboard");
        }

        resp.sendRedirect("/login?error=unknown_role");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
