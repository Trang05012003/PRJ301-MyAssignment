<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Student Dashboard</h2>

<h4>All Courses</h4>
<table border="1">
    <tr>
        <th>Course Name</th>
        <th>Subject</th>
        <th>Semester</th>
    </tr>
    <%-- Fetch and display student's courses --%>
    <%--    <%--%>
    <%--        // Assuming `courses` is a list of Course objects--%>
    <%--        List<Course> courses = (List<Course>) request.getAttribute("courses");--%>
    <%--        for (Course course : courses) {--%>
    <%--    %>--%>
    <%--    <tr>--%>
    <%--        <td><%= course.getName() %></td>--%>
    <%--        <td><%= course.getSubject() %></td>--%>
    <%--        <td><%= course.getSemester() %></td>--%>
    <%--    </tr>--%>
    <%--    <% } %>--%>
    <%--</table>--%>

    <%--<h4>Your Grades</h4>--%>
    <%--<table border="1">--%>
    <%--    <tr>--%>
    <%--        <th>Subject</th>--%>
    <%--        <th>Grade</th>--%>
    <%--    </tr>--%>
    <%--    &lt;%&ndash; Fetch and display student's grades &ndash;%&gt;--%>
    <%--    <%--%>
    <%--        // Assuming `grades` is a list of Grade objects--%>
    <%--        List<Grade> grades = (List<Grade>) request.getAttribute("grades");--%>
    <%--        for (Grade grade : grades) {--%>
    <%--    %>--%>
    <%--    <tr>--%>
    <%--        <td><%= grade.getSubject() %></td>--%>
    <%--        <td><%= grade.getScore() %></td>--%>
    <%--    </tr>--%>
    <%--    <% } %>--%>
</table>

<form action="<%= request.getContextPath() %>/logout" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
