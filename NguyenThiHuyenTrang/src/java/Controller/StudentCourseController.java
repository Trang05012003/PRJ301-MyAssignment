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
import model.Course;
import model.User;

/**
 *
 * @author minhn
 */
public class StudentCourseController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentCourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentCourseController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String studentIdParam = request.getParameter("studentId");

        if (studentIdParam != null && !studentIdParam.isEmpty()) {
            try {
                int studentId = Integer.parseInt(studentIdParam);
                List<Course> list = courser.getCoursesByStudentId(studentId);
                request.setAttribute("courses", list);
                request.setAttribute("studentId", studentIdParam);
                request.getRequestDispatcher("student_course.jsp").forward(request, response);

            } catch (NumberFormatException e) {
                // Handle invalid studentId parameter
                response.sendRedirect("error.jsp");
            }
        } else {
            // Handle case where studentId parameter is missing or empty
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("User");
            if (user != null) {
                int userId = user.getId();
                List<Course> courses = courser.getCoursesByStudentId(userId);
                request.setAttribute("courses", courses);
                request.setAttribute("studentId", userId);
                request.getRequestDispatcher("student_course.jsp").forward(request, response);
            } else {
                // Handle case where user is not logged in
                response.sendRedirect("login.jsp");
            }
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
