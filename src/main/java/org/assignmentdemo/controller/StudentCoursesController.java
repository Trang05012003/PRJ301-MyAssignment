package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.service.CourseService;
import org.assignmentdemo.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentCoursesController", urlPatterns = {"/admin/students/*", "/lecturer/students/*"})
public class StudentCoursesController extends HttpServlet {
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

        if (pathParts.length < 4) {
            response.sendRedirect("/admin/dashboard/students");
            return;
        }
        Integer studentIdParam = Integer.parseInt(pathParts[3]);

        List<Course> courses = this.courseService.getCoursesByStudentId(studentIdParam);

        request.setAttribute("courses", courses);
        request.setAttribute("studentId", studentIdParam);

        request.getRequestDispatcher("/view/student/courses.jsp").forward(request, response);
    }
}
