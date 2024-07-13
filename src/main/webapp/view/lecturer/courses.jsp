<%@ page import="org.assignmentdemo.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="org.assignmentdemo.model.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer Courses</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Lecturer Courses</h2>
<table border="1">
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Semester</th>
        <th>Action</th>
    </tr>
    <% ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
        for (Course course : courses) { %>
    <tr>
        <td><%= course.getId() %></td>
        <td><%= course.getName() %></td>
        <td><%= course.getSemid() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/lecturer/dashboard/courses/<%= course.getId() %>?lecturerId=<%= request.getAttribute("lecturerId") %>">
                View Students
            </a>
        </td>
    </tr>
    <% } %>
</table>
<br>
<a href="<%= request.getContextPath() %>/lecturer/dashboard">Back to Lecturer dashboard</a>
</body>
</html>
