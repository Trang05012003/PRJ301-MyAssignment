<%-- 
    Document   : list_lecturer
    Created on : Jul 14, 2024, 8:43:07 AM
    Author     : minhn
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lecturer List</title>
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
        a {
            text-decoration: none;
            color: #007bff;
            padding: 10px 20px;
            border: 1px solid #007bff;
            border-radius: 5px;
            display: inline-block;
            margin: 10px 0;
        }
        a:hover {
            background-color: #007bff;
            color: #fff;
        }
    </style>
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
    <c:forEach var="lecturer" items="${lecturers}">
        <tr>
            <td>${lecturer.id}</td>
            <td>${lecturer.username}</td>
            <td>${lecturer.name}</td>
            <td>${lecturer.role}</td>
            <td><a href="/NguyenThiHuyenTrang/lecturercourses?lecturerId=${lecturer.id}">View Courses Of Lecturer</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<c:choose>
            <c:when test="${role == 'admin'}">
                <a href="/NguyenThiHuyenTrang/admindashbroad.jsp">Back to Dashboard</a>
            </c:when>
            <c:otherwise>
                <a href="/NguyenThiHuyenTrang/lecturerdashboard">Back to Lecturer Courses</a>
            </c:otherwise>
        </c:choose>
</body>
</html>

