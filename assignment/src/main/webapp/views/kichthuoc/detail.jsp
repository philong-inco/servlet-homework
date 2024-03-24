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

<body class="positon-relative">
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
    </div>
    <div class="position-fixed bottom-0 text-end text-warning" style="z-index: 999999; right: 0;">
        <c:if test="${account != null}">
            <span class="p-2 pb-3 bg-dark text-warning" style="border-top-left-radius: 10px">Chào, ${account.ten}</span>
        </c:if>
    </div>

    <!-- Body -->
    <div class="d-flex container" style="min-height: 450px;">
        <div class="w-25 mt-3 ">
            <div class="border-1 me-5 rounded shadow position-sticky" style="top: 80px;">
                <nav class="navbar bg-light">
                    <div class="container-fluid">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="/assignment_war_exploded/san-pham/list">Sản phẩm</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="/assignment_war_exploded/hoa-don/list">Hóa đơn</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="/assignment_war_exploded/nhan-vien/list">Nhân viên</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="/assignment_war_exploded/khach-hang/list">Khách hàng</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <nav class="navbar" style="background: antiquewhite">
                    <div class="container-fluid">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="/assignment_war_exploded/kich-thuoc/list">Quản lý kích thước</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark fw-bold" href="/assignment_war_exploded/mau-sac/list">Quản lý màu sắc</a>
                            </li>

                        </ul>
                    </div>
                </nav>
            </div>

        </div>
        <div class="w-75  mt-3">
            <div class="d-flex justify-content-between mb-3">
                <h1 class="my-2 h4 d-inline-block">Chi tiết kích thước</h1>
                <a href="#" class="btn btn-secondary m-1">Danh sách kích thước</a>
            </div>
            <div>
                <form method="GET" action="/assignment_war_exploded/kich-thuoc/edit?${kt.id}">
                    <div class="mt-3">
                        <label class="form-label">ID kích thước: ${kt.id}</label>
                        <input class="form-control" type="hidden" name="id" value="${kt.id}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Mã kích thước:</label>
                        <input class="form-control" type="text" name="ma" value="${kt.ma}" disabled>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Tên kích thước:</label>
                        <input class="form-control" type="text" name="ten" value="${kt.ten}" disabled>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Trạng thái:</label>
                        <select class="form-control" name="trangthai" disabled>
                            <option class="text-secondary" value="">-- Lựa chọn --</option>
                            <option ${kt.trangThai == 1 ? "selected" : ""} class="text-success" value="1">Hoạt động</option>
                            <option ${kt.trangThai == 0 ? "selected" : ""} class="text-danger" value="0">Không hoạt động</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <button class="btn btn-warning">Sửa</button>
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