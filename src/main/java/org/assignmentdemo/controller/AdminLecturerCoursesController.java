package org.assignmentdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.model.User;
import org.assignmentdemo.service.CourseService;
import org.assignmentdemo.service.UserService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/admin/lecturer/lecturerCourses/*")
public class AdminLecturerCoursesController extends HttpServlet {
    private CourseService courseService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        courseService = new CourseService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getRequestURI();
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 4) {
                int courseId = Integer.parseInt(pathParts[4]);
                int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));

                ArrayList<User> students = this.courseService.getStudentsByLecturerAndCourse(lecturerId, courseId);
                request.setAttribute("students", students);
                request.setAttribute("lecturerId", lecturerId);
                request.getRequestDispatcher("/view/admin/list_lecturer_course_students.jsp").forward(request, response);
                return;
            }

            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            ArrayList<Course> courses = this.courseService.getCoursesByLecturerId(lecturerId);

            request.setAttribute("courses", courses);
            request.setAttribute("lecturerId", lecturerId);
            request.getRequestDispatcher("/view/admin/list_lecturer_courses.jsp").forward(request, response);
        }
    }
}
