package org.assignmentdemo.controller.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignmentdemo.controller.auth.BaseRequiredLecturerAuthenticationController;
import org.assignmentdemo.dal.ExamDbContext;
import org.assignmentdemo.dal.GradeDbContext;
import org.assignmentdemo.dal.StudentDbContext;
import org.assignmentdemo.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@WebServlet(name = "TakeExam", urlPatterns = "/exams")
public class TakeExam extends BaseRequiredLecturerAuthenticationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, User user, Lecturer lecturer)
            throws ServletException, IOException {
        StudentDbContext stuDB = new StudentDbContext();
        ExamDbContext examDB = new ExamDbContext();
        GradeDbContext graDB = new GradeDbContext();

        int cid = Integer.parseInt(request.getParameter("cid"));
        ArrayList<Student> students = stuDB.getStudentsByCourse(cid);

        String[] raw_eids = request.getParameterValues("eid");
        ArrayList<Integer> eids = new ArrayList<>();
        for (String raw_eid : raw_eids) {
            eids.add(Integer.parseInt(raw_eid));
        }

        ArrayList<Exam> exams = examDB.getExamsByExamIds(eids);
        ArrayList<Grade> grades = graDB.getGradesFromExamIds(eids);

        request.setAttribute("students", students);
        request.setAttribute("exams", exams);
        request.setAttribute("grades", grades);

        request.getRequestDispatcher("../view/exam/take.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, User user, Lecturer lecturer)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        HashSet<Integer> eids = new HashSet<>();

        String[] raw_gradeids = request.getParameterValues("gradeid");
        ArrayList<Grade> grades = new ArrayList<>();
        for (String raw_gradeid : raw_gradeids) {
            int sid = Integer.parseInt(raw_gradeid.split("_")[0]);
            int eid = Integer.parseInt(raw_gradeid.split("_")[1]);

            eids.add(eid);

            String raw_score = request.getParameter("score" + sid + "_" + eid);
            if (raw_score.length() > 0) {
                Grade g = new Grade();
                Exam e = new Exam();
                e.setId(eid);

                Student s = new Student();
                s.setId(sid);

                g.setExam(e);
                g.setStudent(s);
                g.setScore(Float.parseFloat(raw_score));

                grades.add(g);
            }
        }

        GradeDbContext db = new GradeDbContext();
        db.insertGradesForCourse(cid, grades);
        String url_param = "";
        for (Integer eid : eids) {
            url_param += "&eid=" + eid;
        }
        response.sendRedirect("take?cid=" + cid + url_param);


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
