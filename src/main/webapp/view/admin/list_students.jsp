<%@ page import="java.util.List" %>
<%@ page import="org.assignmentdemo.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Student List</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Name</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <% List<User> students = (List<User>) request.getAttribute("students");
        String role = (String) request.getSession().getAttribute("role");
        for (User student : students) { %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getUsername() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getRole() %></td>
        <% if ("admin".equals(role)) { %>
            <% request.setAttribute("role", "admin"); %>
            <td><a href="<%= request.getContextPath() %>/admin/students/<%= student.getId() %>/courses">View Details</a></td>
        <% } else { %>
            <% request.setAttribute("role", "lecturer"); %>
            <td><a href="<%= request.getContextPath() %>/lecturer/students/<%= student.getId() %>/courses">View Details</a></td>
        <% } %>
    </tr>
    <% } %>
</table>
<br>
<% if ("admin".equals(role)) { %>
<a href="<%= request.getContextPath() %>/admin/dashboard">Back to Dashboard</a>
<% } else { %>
<a href="<%= request.getContextPath() %>/lecturer/dashboard">Back to Lecturer Courses</a>
<% } %>
</body>
</html>
