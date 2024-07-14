<%-- 
    Document   : login
    Created on : Jun 26, 2024, 10:26:35 PM
    Author     : sonnt-local
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="icon" type="image/png" th:href="@{/images/icons/favicon.ico"/>
        <link rel="stylesheet"  href="vendor/bootstrap_login/css/bootstrap.min.css">
        <link rel="stylesheet"  href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet"  href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet"  href="vendor/animate/animate.css">
        <link rel="stylesheet"  href="vendor/animsition/css/animsition.min.css">
        <link rel="stylesheet"  href="vendor/select2/select2.min.css">
        <link rel="stylesheet"  href="css/util_login.css">
        <link rel="stylesheet"  href="css/main_login.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="Login">
            <div class="container-login100" style="background-image: url('images/bg.png');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form action="login" method="post" class="login100-form validate-form">
                        <span class="login100-form-title p-b-49">
                            Login
                        </span>
                        <div class="wrap-input100 validate-input m-b-23" data-validate="Username is required">
                            <span class="label-input100">Username</span>
                            <label>
                                <input class="input100" type="text" name="username" placeholder="Type your username">
                            </label>
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <label>
                                <input class="input100" type="password" name="password" placeholder="Type your password">
                            </label>
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <div class="container-login100-form-btn mt-5">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button type="submit" class="login100-form-btn">
                                    Login
                                </button>
                            </div>
                        </div>
                        <c:if test="${error}">
                            <p>${error}</p>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
