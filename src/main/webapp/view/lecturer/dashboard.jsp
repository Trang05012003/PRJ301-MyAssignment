<%@ page import="org.assignmentdemo.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lecturer Dashboard</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Lecturer Dashboard</h2>
<h3>Welcome, <%= session.getAttribute("username") %>!</h3>

<h4>All Courses</h4>
<table border="1">
    <tr>
        <th>Course Name</th>
        <th>Subject</th>
        <th>Semester</th>
    </tr>
    <%-- Fetch and display lecturer's courses --%>
    <%-- Assuming `courses` is a list of Course objects --%>
<%--    <% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>--%>
<%--    <% for (Course course : courses) { %>--%>
<%--    <tr>--%>
<%--        <td><%= course.getCname() %></td>--%>
<%--        <td><%= course.getSubject() %></td>--%>
<%--        <td><%= course.getSemester() %></td>--%>
<%--    </tr>--%>
<%--    <% } %>--%>
</table>

<%-- Uncomment the following section if displaying grades of students is required --%>
<%--<h4>Grades of Your Students</h4>--%>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Student</th>--%>
<%--        <th>Subject</th>--%>
<%--        <th>Grade</th>--%>
<%--    </tr>--%>
<%--    &lt;%&ndash; Fetch and display students' grades &ndash;%&gt;--%>
<%--    <%--%>
<%--        // Assuming `studentGrades` is a list of StudentGrade objects--%>
<%--        List<StudentGrade> studentGrades = (List<StudentGrade>) request.getAttribute("studentGrades");--%>
<%--        for (StudentGrade studentGrade : studentGrades) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= studentGrade.getStudentName() %></td>--%>
<%--        <td><%= studentGrade.getSubject() %></td>--%>
<%--        <td><%= studentGrade.getScore() %></td>--%>
<%--    </tr>--%>
<%--    <%-- } %>--%>
<%--</table>--%>

<form action="<%= request.getContextPath() %>/logout" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
