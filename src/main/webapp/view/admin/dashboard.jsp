<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="<%= request.getContextPath() %>/css/text.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Admin Dashboard</h2>
<h3>Welcome, <%= session.getAttribute("username") %>!</h3>

<h4>Manage Grades</h4>
<form action="<%= request.getContextPath() %>/admin/addGrade" method="post">
    <label>Student ID:</label> <input type="text" name="studentId" required><br>
    <label>Subject:</label> <input type="text" name="subject" required><br>
    <label>Score:</label> <input type="text" name="score" required><br>
    <button type="submit">Add Grade</button>
</form>

<h4>Manage Users</h4>
<form action="<%= request.getContextPath() %>/admin/addUser" method="post">
    <label>Username:</label> <input type="text" name="username" required><br>
    <label>Password:</label> <input type="password" name="password" required><br>
    <label>Role:</label>
    <select name="role">
        <option value="lecturer">Lecturer</option>
        <option value="student">Student</option>
        <!-- Add more roles as needed -->
    </select><br>
    <label>Name:</label> <input type="text" name="name" required><br>
    <button type="submit">Add User</button>
</form>

<h4>Manage Courses</h4>
<form action="<%= request.getContextPath() %>/admin/addCourse" method="post">
    <label>Course Name:</label> <input type="text" name="courseName" required><br>
    <label>Subject:</label> <input type="text" name="subject" required><br>
    <label>Semester:</label> <input type="text" name="semester" required><br>
    <button type="submit">Add Course</button>
</form>

<form action="<%= request.getContextPath() %>/logout" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
