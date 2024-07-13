<%@ page import="org.assignmentdemo.model.Assessment" %>
<%@ page import="org.assignmentdemo.model.Grade" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course Grades</title>
    <style>
    </style>
</head>
<body>
<h2>Course Grades for ${student.name}</h2>
<table border="1">
    <thead>
    <tr>
        <th>Assessment Name</th>
        <th>Weight</th>
        <th>Score</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Grade> grades = (List<Grade>) request.getAttribute("grades");
        List<Assessment> assessments = (List<Assessment>) request.getAttribute("assessments");

        for (Assessment assessment : assessments) {
            boolean found = false;
            for (Grade grade : grades) {
                if (grade.getAid() == assessment.getId()) {
                    found = true;
    %>
    <tr>
        <td><%= assessment.getName() %>
        </td>
        <td><%= assessment.getWeight() %>
        </td>
        <td><%= grade.getScore() %>
        </td>
    </tr>
    <%
            }
        }
        if (!found) {
    %>
    <tr>
        <td><%= assessment.getName() %>
        </td>
        <td><%= assessment.getWeight() %>
        </td>
        <td></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
