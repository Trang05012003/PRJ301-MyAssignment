<%-- 
    Document   : admindashbroad
    Created on : Jul 14, 2024, 8:19:08 AM
    Author     : minhn
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Dashboard</title>
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
            h4 {
                color: #555;
                margin-bottom: 15px;
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
        <h2>Admin Dashboard</h2>

        <h4>Lists</h4>
        <a href="/NguyenThiHuyenTrang/listlecturers">View Lecturers</a><br>
        <a href="/NguyenThiHuyenTrang/liststudent">View Students</a><br>

        <form action="logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </body>
</html>

