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

<a href="/admin/dashboard/students">View all students</a>
<br/>
<a href="/lecturer/dashboard/courses">View all your courses</a>

<form action="<%= request.getContextPath() %>/logout" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
