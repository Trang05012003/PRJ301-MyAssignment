/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dal.CourseContext;
import dal.UserContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import model.Course;
import model.User;

/**
 *
 * @author minhn
 */
public class LecturerCourse extends HttpServlet {

    private UserContext user;
    private CourseContext courser;

    @Override
    public void init() throws ServletException {
        super.init();
        this.user = new UserContext();
        this.courser = new CourseContext();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("User") == null) {
            // No session or user not logged in, redirect to login page
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String role = (String) session.getAttribute("role");
        // User is not an admin, redirect to their dashboard
        if (role.equals("student")) {
            request.getRequestDispatcher("student_course.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        int lecturerId = user != null ? user.getId() : -1;

        // Check if lecturerId is provided in the request parameters
        String lecturerIdParam = request.getParameter("lecturerId");
        if (lecturerIdParam != null && !lecturerIdParam.isEmpty()) {
            try {
                lecturerId = Integer.parseInt(lecturerIdParam);
            } catch (NumberFormatException e) {
                // Handle invalid lecturerId parameter
                response.sendRedirect("error.jsp");
                return;
            }
        }

        if (lecturerId != -1) {
            // Get the list of courses for the lecturer
            List<Course> courses = courser.getCoursesByLecturerId(lecturerId);

            // Set attributes in request to be accessed by JSP
            request.setAttribute("courses", courses);
            request.setAttribute("lecturerId", lecturerId);

            // Forward the request to lecturercourse.jsp
            request.getRequestDispatcher("lecturercourse.jsp").forward(request, response);
        } else {
            // Handle case where lecturerId is not provided or invalid
            response.sendRedirect("error.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
