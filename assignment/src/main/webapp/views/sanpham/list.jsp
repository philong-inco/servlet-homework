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
        function deleteById(id) {
            if (confirm("Bạn chắc chắn xóa bản ghi này?")) {
                window.location.href = "http://localhost:8080/assignment_war_exploded/san-pham/delete?id=" + id;
            }
        }

        function visiable(id) {
            var div = document.getElementById(id);
            div.style.display = (div.style.display === "none") ? "block" : "none";
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
            </div>

            <div class="mt-3 border-1 me-5 rounded shadow position-sticky" style="top: 80px;">
                <nav class="navbar bg-light">
                    <div class="container-fluid">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link text-warning fw-bold" href="/assignment_war_exploded/kich-thuoc/list">Quản lý kích thước</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-warning fw-bold" href="/assignment_war_exploded/mau-sac/list">Quản lý màu sắc</a>
                            </li>

                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <div class="w-75  mt-3">
            <div class="d-flex justify-content-between mb-3">
                <h1 class="my-2 h4 d-inline-block">Quản lý sản phẩm</h1>
                <a href="/assignment_war_exploded/san-pham/create" class="btn btn-success m-1">Thêm</a>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Mã sản phẩm</th>
                    <th>Tên</th>
                    <th>Trạng thái</th>
                    <th colspan="4">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ sanphamlist }" var="sp">
                    <tr style="position: relative";>
                        <td>${ sp.id }</td>
                        <td>${ sp.ma }</td>
                        <td>${ sp.ten }</td>
                        <td>
                            <c:if test="${sp.trangThai == 1}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-success border rounded me-2" style="width: 10px; height: 10px"></div>
                                    <span class="text-success " style="font-size: 14px">Hoạt động</span>
                                </div>

                            </c:if>
                            <c:if test="${sp.trangThai == 0}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-danger border rounded me-2" style="width: 10px; height: 10px"></div>
                                    <span class="text-danger" style="font-size: 14px">Không hoạt động</span>
                                </div>

                            </c:if>
                        </td>

                        <td class="p-1 m-0" style="width: 1px">
                            <a class="btn btn-primary btn-sm text-light"
                               href="/assignment_war_exploded/san-pham/detail?id=${sp.id}">Xem</a>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <a class="btn btn-warning btn-sm text-light"
                               href="/assignment_war_exploded/san-pham/edit?id=${sp.id}">Sửa</a>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <button class="btn btn-danger btn-sm text-light" onclick="deleteById(${sp.id})">Xóa</button>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <button class="btn btn-danger btn-sm text-light" onclick="visiable(${sp.id})">BT</button>
                                <%-- Biến thể--%>
                            <div class="border border-danger rounded shadow bg-light" id="${sp.id}"
                                 style="display: none; position: absolute; top: 40px; right: 0; z-index: 9999;">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Mã BT</th>
                                        <th>Màu</th>
                                        <th>Kích thước</th>
                                        <th>Đơn giá</th>
                                        <th>Số lượng</th>
                                        <th>Trạng thái</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${bienthelist[sp.id]}" var="bt">
                                        <tr>
                                            <td>${bt.maSPCT}</td>
                                            <td>${bt.mauSac}</td>
                                            <td>${bt.kichThuoc}</td>
                                            <td>${bt.donGia}</td>
                                            <td>${bt.soLuong}</td>
                                            <td>
                                                <c:if test="${bt.trangThai == 1}">
                                                    <div class="d-flex align-items-center">
                                                        <div class="bg-success border rounded me-2"
                                                             style="width: 10px; height: 10px"></div>
                                                        <span class="text-success "
                                                              style="font-size: 14px">Hoạt động</span>
                                                    </div>

                                                </c:if>
                                                <c:if test="${bt.trangThai == 0}">
                                                    <div class="d-flex align-items-center">
                                                        <div class="bg-danger border rounded me-2"
                                                             style="width: 10px; height: 10px"></div>
                                                        <span class="text-danger" style="font-size: 14px">Không hoạt động</span>
                                                    </div>

                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <div class="text-center py-2">
                                    <a class="btn btn-sm btn-outline-success d-inline-block" href="/assignment_war_exploded/san-pham-chi-tiet/properties?idSP=${sp.id}">Thêm</a>
                                    <a class="btn btn-sm btn-outline-warning d-inline-block" href="/assignment_war_exploded/san-pham-chi-tiet/list?idSP=${sp.id}">Sửa</a>
                                </div>
                            </div>
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
