<%--
  Created by IntelliJ IDEA.
  User: longnvph31848
  Date: 13/03/2024
  Time: 09:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function deleteById(id){
            if(confirm("Bạn chắc chắn xóa bản ghi này?")){
                window.location.href = "http://localhost:8080/assignment_war_exploded/khach-hang/delete?id=" + id;
            }
        }
    </script>
</head>

<body>
<div>
    <!-- Header -->
    <div class="bg-danger container-fluid position-sticky top-0">
        <div class="container d-flex py-3">
            <!-- Logo -->
            <div class="w-25 text-light h3">
                WEB SERVLET
            </div>
            <!-- Search -->
            <div class="w-75">
                <form action="" class="d-flex mx-5">
                    <input type="text" name="search" class="form-control me-2" placeholder="Tìm sản phẩm...">
                    <button class="btn btn-dark">Tìm</button>
                </form>
            </div>
            <!-- Admin -->
            <div class="w-25 d-flex justify-content-end">
                <a href="#" class="text-decoration-none text-light d-inline-block mt-2 me-5">Admin</a>
                <a href="#" class="text-decoration-none text-light d-inline-block mt-2">Giỏ hàng</a>
            </div>
        </div>
        <!-- Navbar -->
        <div>

        </div>
    </div>

    <!-- Body -->
    <div class="d-flex container" style="min-height: 450px;">
        <div class="w-25 mt-3 ">
            <div class="border-1 me-5 rounded shadow position-sticky" style="top: 80px;">
                <nav class="navbar bg-light">
                    <div class="container-fluid">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="#">Sản phẩm</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="#">Hóa đơn</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="#">Nhân viên</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="#">Khách hàng</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <div class="w-75  mt-3">
            <div class="d-flex justify-content-between mb-3">
                <h1 class="my-2 h4 d-inline-block">Quản lý khách hàng</h1>
                <a href="/assignment_war_exploded/khach-hang/create" class="btn btn-success m-1">Thêm</a>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Mã khách hàng</th>
                    <th>Tên</th>
                    <th>SĐT</th>
                    <th>Trạng thái</th>
                    <th colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ khachhanglist }" var="kh">
                    <tr>

                        <td>${ kh.id }</td>
                        <td>${ kh.maKH }</td>
                        <td>${ kh.ten }</td>
                        <td>${ kh.sdt }</td>
                        <td>${ (kh.trangThai == 1)? "Hoạt động": "Không hoạt động" }</td>

                        <td class="p-1 m-0" style="width: 1px">
                            <a class="btn btn-primary btn-sm text-light" href="/assignment_war_exploded/khach-hang/detail?id=${kh.id}">Xem</a>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <a class="btn btn-warning btn-sm text-light" href="/assignment_war_exploded/khach-hang/edit?id=${kh.id}">Sửa</a>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <button class="btn btn-danger btn-sm text-light" onclick="deleteById(${kh.id})">Xóa</button>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Footer -->
    <div class="bg-dark py-3 text-center">
        <span class="text-light my-2">longnvph31848 - Nguyễn Vĩnh Long</span>
    </div>
</div>
</body>

</html>