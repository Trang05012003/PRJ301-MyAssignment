<%-- 
    Document   : studentdashbroad
    Created on : Jul 14, 2024, 8:53:04 AM
    Author     : minhn
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <link href="/NguyenThiHuyenTrang/css/text.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        form {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h2>Student Dashboard</h2>

<h4>All Courses</h4>
<table border="1">
    <tr>
        <th>Course Name</th>
        <th>Subject</th>
        <th>Semester</th>
        <th>Action</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.name}</td>
            <td>${course.subject}</td>
            <td>${course.semester}</td>
            <td><a href="/NguyenThiHuyenTrang/studentcourse">View Detail</a></td>
        </tr>
    </c:forEach>
</table>

<form action="/NguyenThiHuyenTrang/logout" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
