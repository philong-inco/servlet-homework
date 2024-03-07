<%--
  Created by IntelliJ IDEA.
  User: longnvph31848
  Date: 07/03/2024
  Time: 05:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo màu sắc</title>
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
<h1 class="text-center my-3">Tạo màu sắc</h1>
<div class="container d-flex justify-content-center">

    <form method="POST" action="/demo2_war_exploded/mau-sac/create" class="w-50">

        <div class="mt-3">
            <lable class="form-label">Mã màu:</lable>
            <input class="form-control" type="text" name="colorCode">
        </div>

        <div class="mt-3">
            <lable class="form-label">Tên màu:</lable>
            <input class="form-control" type="text" name="colorName">
        </div>

        <div class="mt-3">
            <lable class="form-label">Trạng thái:</lable>
            <br>
            <input type="radio" name="colorStatus" value="enable"> Hoạt động
            <input type="radio" name="colorStatus" value="disable"> Không hoạt động
        </div>

        <div class="mt-3">
            <button class="btn btn-warning btn-sm" type="submit">Thêm</button>
        </div>


    </form>
</div>
</body>
</html>
