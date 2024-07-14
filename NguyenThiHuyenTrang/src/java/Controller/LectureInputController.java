/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dal.CourseContext;
import dal.GradeContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Grade;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author minhn
 */
public class LectureInputController extends HttpServlet {

    private CourseContext courseContext;
    private GradeContext gradeContext;

    @Override
    public void init() throws ServletException {
        super.init();
        this.courseContext = new CourseContext();
        this.gradeContext = new GradeContext();
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
            out.println("<title>Servlet LectureInputController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LectureInputController at " + request.getContextPath() + "</h1>");
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

        String[] assessmentIds = request.getParameterValues("assessmentIds[]");
        String studentIdParam = request.getParameter("studentId");

        if (studentIdParam == null ||  studentIdParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Student ID cannot be null or empty");
            return;
        }

        int size;
        try {
            size = Integer.parseInt(request.getParameter("size"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid size parameter");
            return;
        }

        int studentId;
        try {
            studentId = Integer.parseInt(studentIdParam);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid studentId or courseId parameter");
            return;
        }

        GradeContext gradeContext = new GradeContext(); // Assuming GradeContext is instantiated properly
        try {
            for (int i = 0; i < size; i++) {
                String assessment = request.getParameter("assessment_" + i);
                String scoreParam = request.getParameter("scores_" + i);

                if (assessment == null || scoreParam == null || assessment.isEmpty() || scoreParam.isEmpty()) {
                    continue; // Skip this iteration and continue with the next one
                }

                float score;
                try {
                    score = Float.parseFloat(scoreParam);
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid score format");
                    return;
                }

                Grade grade = gradeContext.getGradeByUserIdAndAssessmentId(studentId, i + 1);
                if (grade != null) {
                    grade.setScore(score);
                    gradeContext.update(grade); // Update existing grade
                } else {
                    int aid = Integer.parseInt(assessment);
                    grade = new Grade(studentId, aid, score);
                    gradeContext.insert(grade); // Insert new grade
                }
            }

            // Redirect to feedback page after successful submission
            response.sendRedirect("lecturedashbroad.jsp");
        } catch (Exception e) { // Handle exception gracefully
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request");
        }
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
