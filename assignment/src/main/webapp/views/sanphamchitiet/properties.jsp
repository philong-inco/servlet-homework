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
                <h1 class="my-2 h4 d-inline-block">Chọn thuộc tính cho sản phẩm</h1>
                <a href="/assignment_war_exploded/san-pham/list" class="btn btn-secondary m-1">Danh sách sản phẩm</a>
            </div>
            <div>
                <form method="GET" action="/assignment_war_exploded/san-pham-chi-tiet/create">
                    <div class="mt-3">
                        <label class="form-label">Tên sản phẩm: <span class="text-danger">${sp.ten}</span></label>
                        <input class="form-control" type="hidden" name="idSP" value="${sp.id}">
                    </div>

                    <div class="d-flex">
                        <div class="mt-3 w-50">
                            <label class="form-label">Màu sắc:</label><br>
                            <c:forEach items="${mausaclist}" var="ms">
                                <input id="${ms.id}-color" type="checkbox" name="mausac" value="${ms.id}">
                                <label for="${ms.id}-color">${ms.ten}</label>
                                <br>
                            </c:forEach>
                        </div>
                        <div class="mt-3 w-50">
                            <label class="form-label">Kích thước:</label><br>
                            <c:forEach items="${kichthuoclist}" var="kt">
                                <input id="${kt.id}-color" type="checkbox" name="kichthuoc" value="${kt.id}">
                                <label for="${kt.id}-color">${kt.ten}</label>
                                <br>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="mt-3">
                        <button class="btn btn-success">Tiếp tục</button>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <!-- Footer -->
    <div class="bg-dark py-3 text-center mt-3">
        <span class="text-light my-2">longnvph31848 - Nguyễn Vĩnh Long</span>
    </div>
</div>
</body>

</html>