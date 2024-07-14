<%-- 
    Document   : student_course_grade
    Created on : Jul 14, 2024, 8:48:28 AM
    Author     : minhn
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Course Grades</title>
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
        </style>
    </head>
    <body>
        <h2>Course Grades for ${student.name}</h2>
        <form action="lectureinput" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Assessment Name</th>
                        <th>Weight</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="assessment" items="${assessments}" varStatus="loop">
                        <c:set var="foundGrade" value="${null}"/>
                        <c:forEach var="grade" items="${list}">
                            <c:if test="${grade.aid eq assessment.id}">
                                <c:set var="foundGrade" value="${grade}"/>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <td>${assessment.name}</td>
                            <td>${assessment.weight}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${sessionScope.role eq 'lecturer'}">
                                        <input type="hidden" name="assessment_${loop.index}" value="${assessment.id}">
                                        <input type="text" name="scores_${loop.index}" value="${not empty foundGrade ? foundGrade.score : ''}">
                                    </c:when>
                                    <c:otherwise>
                                        ${not empty foundGrade ? foundGrade.score : ''}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <input type="hidden" name="size" value="${size}">
            <input type="hidden" name="courseId" value="${courseId}">
            <input type="hidden" name="studentId" value="${studentId}">
            <c:if test="${sessionScope.role eq 'lecturer'}">
                <button type="submit">Submit All Scores</button>
            </c:if>
        </form>

    </body>
</html>
