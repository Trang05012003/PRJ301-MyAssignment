package org.assignmentdemo.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.model.User;
import org.assignmentdemo.service.CourseService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LecturerDashboardController", urlPatterns = "/lecturer/dashboard/*")
public class LecturerDashboardController extends HttpServlet {
    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        Integer lecturerId = (Integer) request.getSession(false).getAttribute("id");

        switch (path) {
            case "/lecturer/dashboard": {
                request.getRequestDispatcher("/view/lecturer/dashboard.jsp").forward(request, response);
                break;
            }
            case "/lecturer/dashboard/courses": {
                Integer id = (Integer) request.getSession().getAttribute("id");
                List<Course> courses = this.courseService.getCoursesByLecturerId(id);
                request.setAttribute("courses", courses);
                request.getRequestDispatcher("/view/lecturer/courses.jsp").forward(request, response);
                break;
            }
            default: {
                String[] pathParts = path.split("/");
                if (pathParts.length > 4) {
                    int courseId = Integer.parseInt(pathParts[4]);

                    ArrayList<User> students = this.courseService.getStudentsByLecturerAndCourse(lecturerId, courseId);
                    request.setAttribute("students", students);
                    request.setAttribute("lecturerId", lecturerId);
                    request.getRequestDispatcher("/view/admin/list_lecturer_course_students.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Lecturer Dashboard Controller";
    }
}
