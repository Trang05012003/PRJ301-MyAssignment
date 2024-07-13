<%@ page import="java.util.List" %>
<%@ page import="org.assignmentdemo.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer Course Students</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Lecturer Course Students</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Name</th>
        <th>Role</th>
        <th>Active</th>
    </tr>
    <% List<User> students = (List<User>) request.getAttribute("students");
        String role = (String) request.getSession().getAttribute("role");
        for (User student : students) { %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getUsername() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getRole() %></td>
        <td><%= student.getActiveCourse() ? "Active" : "Closed" %></td>
    </tr>
    <% } %>
</table>
<br>
<% if ("admin".equals(role)) { %>
    <a href="<%= request.getContextPath() %>/admin/lecturer/lecturerCourses?lecturerId=<%= request.getAttribute("lecturerId")%>">Back to Lecturer Courses</a>
<% } else { %>
    <a href="/lecturer/dashboard/courses">Back to Lecturer Courses</a>
<% } %>
</body>
</html>
