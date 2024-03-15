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
                <h1 class="my-2 h4 d-inline-block">Thêm nhân viên</h1>
                <a href="/assignment_war_exploded/nhan-vien/list" class="btn btn-secondary m-1">Danh sách nhân viên</a>
            </div>
            <div>
                <form method="POST" action="/assignment_war_exploded/nhan-vien/store">
                    <div class="mt-3">
                        <label class="form-label">Mã nhân viên:</label>
                        <input class="form-control" type="text" name="ma" placeholder="Nhập mã nhân viên">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Tên nhân viên:</label>
                        <input class="form-control" type="text" name="ten" placeholder="Nhập tên nhân viên">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Username:</label>
                        <input class="form-control" type="text" name="username" placeholder="Nhập username">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Mật khẩu:</label>
                        <input class="form-control" type="password" name="matkhau" placeholder="Nhập mật khẩu">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Trạng thái:</label>
                        <select class="form-control" name="trangthai" id="">
                            <option class="text-secondary" value="">-- Lựa chọn --</option>
                            <option class="text-success" value="1">Hoạt động</option>
                            <option class="text-danger" value="0">Không hoạt động</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <button class="btn btn-success">Thêm mới</button>
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