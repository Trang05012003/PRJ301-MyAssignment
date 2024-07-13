package org.assignmentdemo.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.dal.UserDBContext;
import org.assignmentdemo.model.User;

import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDBContext db = new UserDBContext();
        User user = db.checkCorrectCredential(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.getWriter().println("login successful: " + user.getDisplayname());
        } else {
            response.getWriter().println("login failed!");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
