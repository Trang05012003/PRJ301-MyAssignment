<%@ page import="java.util.List" %>
<%@ page import="org.assignmentdemo.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer List</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Lecturer List</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Name</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <% List<User> lecturers = (List<User>) request.getAttribute("lecturers");
        for (User lecturer : lecturers) { %>
    <tr>
        <td><%= lecturer.getId() %></td>
        <td><%= lecturer.getUsername() %></td>
        <td><%= lecturer.getName() %></td>
        <td><%= lecturer.getRole() %></td>
        <td><a href="<%= request.getContextPath() %>/admin/lecturer/lecturerCourses?lecturerId=<%= lecturer.getId() %>">View Courses Of Lecture</a></td>
    </tr>
    <% } %>
</table>
<br>
<a href="<%= request.getContextPath() %>/admin/dashboard">Back to Dashboard</a>
</body>
</html>
