<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecturer Dashboard</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            h2 {
                color: #333;
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
        <a href="/NguyenThiHuyenTrang/lecturercourses">View all your courses</a>

        <form action="logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </body>
</html>
