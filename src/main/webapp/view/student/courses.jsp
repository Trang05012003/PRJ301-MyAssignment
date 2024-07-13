<%@ page import="org.assignmentdemo.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Courses</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Student Courses</h2>
<table border="1">
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Semester</th>
        <th>Action</th>
    </tr>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("courses");
        String role = (String) request.getSession().getAttribute("role");
        for (Course course : courses) {
    %>
    <tr>
        <td><%= course.getId() %>
        </td>
        <td><%= course.getName() %>
        </td>
        <td><%= course.getSemid() %>
        </td>
        <td>
            <% if ("admin".equals(role)) { %>
            <a href="<%= request.getContextPath() %>/admin/students/score/courses/<%= course.getId() %>?studentId=<%= request.getAttribute("studentId") %>">
                View Grades
            </a>
            <% } else { %>
            <a href="<%= request.getContextPath() %>/lecturer/students/score/courses/<%= course.getId() %>?studentId=<%= request.getAttribute("studentId") %>">
                View Grades
            </a>
            <% } %>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br>
<a href="<%= request.getContextPath() %>/admin/dashboard/students">Back to Student List</a>
</body>
</html>
