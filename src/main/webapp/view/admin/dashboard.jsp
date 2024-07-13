<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Admin Dashboard</h2>
<h3>Welcome, <%= session.getAttribute("username") %>!</h3>

<h4>Lists</h4>
<a href="/admin/dashboard/lecturers">View Lecturers</a><br>
<a href="/admin/dashboard/students">View Students</a><br>


<form action="<%= request.getContextPath() %>/logout" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
