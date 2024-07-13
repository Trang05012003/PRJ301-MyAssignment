package org.assignmentdemo.controller.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.controller.auth.BaseRequiredLecturerAuthenticationController;
import org.assignmentdemo.dal.CourseDbContext;
import org.assignmentdemo.dal.ExamDbContext;
import org.assignmentdemo.model.Course;
import org.assignmentdemo.model.Exam;
import org.assignmentdemo.model.Lecturer;
import org.assignmentdemo.model.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewCourseByLecturerController", urlPatterns = "/lecturer/courses")
public class ViewCourseByLecturerController extends BaseRequiredLecturerAuthenticationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, User user, Lecturer lecturer)
            throws ServletException, IOException {
        CourseDbContext db = new CourseDbContext();
        int lid = lecturer.getId();
        ArrayList<Course> courses = db.getCoursesByLecturer(lid);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("../view/exam/lecturer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, User user, Lecturer lecturer)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int lid = lecturer.getId();

        ExamDbContext db = new ExamDbContext();
        ArrayList<Exam> exams = db.getExamsByCourse(cid);
        request.setAttribute("exams", exams);

        request.getRequestDispatcher("../view/exam/lecturer.jsp").forward(request, response);


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
