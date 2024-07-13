package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.service.GradeService;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/students/*")
public class AdminStudentScroreController extends HttpServlet {
    private GradeService gradeService;

    @Override
    public void init() throws ServletException {
        super.init();
        gradeService = new GradeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getRequestURI();
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 3) {
                String studentId = pathParts[3];
                response.sendRedirect(request.getContextPath() + "/admin/students/" + studentId);
                return;
            }

            response.sendRedirect("/view/404.jsp");
        }
    }
}
