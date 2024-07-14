<%-- 
    Document   : dashbroad
    Created on : Jul 14, 2024, 1:15:35 AM
    Author     : minhn
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lecturer Courses</title>
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
            form {
                margin-top: 20px;
            }
            button {
                padding: 10px 20px;
                background-color: #28a745;
                border: none;
                color: #fff;
                border-radius: 5px;
                cursor: pointer;
            }
            button:hover {
                background-color: #218838;
            }
        </style>
    </head>
    <body>
        <h2>Lecturer Courses</h2>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Semester</th>
                <th>Action</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.semid}</td>
                    <td>
                        <a href="/NguyenThiHuyenTrang/lecturestudent?courseId=${course.id}&lecturerId=${lecturerId}">
                            View Students
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/NguyenThiHuyenTrang/lecturedashbroad.jsp">Back to Lecturer dashboard</a>
    </body>
</html>

