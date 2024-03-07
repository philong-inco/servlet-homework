<%--
  Created by IntelliJ IDEA.
  User: longnvph31848
  Date: 07/03/2024
  Time: 03:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>From đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div>
    <nav class="navbar navbar-expand-sm bg-light">

        <div class="container text-center">
            <!-- Links -->
            <ul class="navbar-nav w-100">
                <li class="nav-item">
                    <a class="nav-link" href="/demo2_war_exploded/hello-servlet">Hello World</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/demo2_war_exploded/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/demo2_war_exploded/mau-sac/create">Màu sắc</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<h1 class="text-center my-3">Form login</h1>
<div class="container d-flex justify-content-center">

    <form method="POST" action="/demo2_war_exploded/login" class="w-50">

        <div class="mt-3">
            <lable class="form-label">Username:</lable>
            <input class="form-control" type="text" name="username">
        </div>

        <div class="mt-3">
            <lable class="form-label">Password:</lable>
            <input class="form-control" type="password" name="password">
        </div>

        <div class="mt-3">
            <button class="btn btn-warning btn-sm">Login</button>
        </div>


    </form>
</div>
</body>
</html>
