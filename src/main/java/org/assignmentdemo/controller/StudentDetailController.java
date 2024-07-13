package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.model.Assessment;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.model.Grade;
import org.assignmentdemo.model.User;
import org.assignmentdemo.service.CourseService;
import org.assignmentdemo.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentDetailsController", urlPatterns = {"/admin/students/score/courses/*", "/lecturer/students/score/courses/*"})
public class StudentDetailController extends HttpServlet {
    private UserService userService;
    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userService = new UserService();
        this.courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String[] pathParts = path.split("/");

        if (pathParts.length < 6) {
            response.sendRedirect("/admin/dashboard/students");
            return;
        }
        Integer studentIdParam = Integer.parseInt(request.getParameter("studentId"));
        Integer courseIdParam = Integer.parseInt(pathParts[5]);

        List<Grade> grades = this.courseService.getGradesByUserIdAndCourseId(studentIdParam, courseIdParam);
        List<Assessment> assessments = this.courseService.getAssessments();
        User student = this.userService.get(studentIdParam);

        request.setAttribute("grades", grades);
        request.setAttribute("assessments", assessments);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/view/student/course_grades.jsp").forward(request, response);
    }

}
