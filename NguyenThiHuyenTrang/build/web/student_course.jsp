<%-- 
    Document   : student_course
    Created on : Jul 14, 2024, 8:51:18 AM
    Author     : minhn
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Student Courses</title>
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
            .back-link {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <h2>Student Courses</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Semester</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                        <td>${course.semid}</td>
                        <td>
                            <c:choose>
                                <c:when test="${'admin' eq role}">
                                    <a href="/NguyenThiHuyenTrang/studentdetail?studentId=${studentId}&courseId=${course.id}">
                                        View Grades
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/NguyenThiHuyenTrang/studentdetail?studentId=${studentId}&courseId=${course.id}">
                                        View Grades
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:if test="${'admin' eq role}">
            <a href="/NguyenThiHuyenTrang/liststudent" class="back-link">Back to Student List</a>
        </c:if>

    </body>
</html>
