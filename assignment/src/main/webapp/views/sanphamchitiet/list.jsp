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
        function deleteById(id, idSP) {
            if (confirm("Xác nhận xóa biến thể này?")) {
                window.location.href = "/assignment_war_exploded/san-pham-chi-tiet/delete?id=" + id + "&idSP=" + idSP;
            }
        }
    </script>
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
            <div class="my-3">
                <span class="h5">Tên sản phẩm: </span>
                <span class="h5 text-danger">${sp.ten} - [${sp.ma}]</span>
            </div>
            <h1 class="h4 my-3">Danh sách biến thể</h1>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Mã SPCT</th>
                    <th>Màu sắc</th>
                    <th>Kích thước</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Trạng thái</th>
                    <th colspan="2">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ sanphamchitietlist }" var="spct">
                    <tr>

                        <td>${ spct.id }</td>
                        <td>${ spct.maSPCT }</td>
                        <td>${ spct.mauSac }</td>
                        <td>${ spct.kichThuoc }</td>
                        <td>${ spct.donGia }</td>
                        <td>${ spct.soLuong }</td>
                        <td>
                            <c:if test="${spct.trangThai == 1}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-success border rounded me-2"
                                         style="width: 10px; height: 10px"></div>
                                    <span class="text-success "
                                          style="font-size: 14px">Hoạt động</span>
                                </div>

                            </c:if>
                            <c:if test="${spct.trangThai == 0}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-danger border rounded me-2"
                                         style="width: 10px; height: 10px"></div>
                                    <span class="text-danger" style="font-size: 14px">Không hoạt động</span>
                                </div>

                            </c:if>
                        </td>

                        <td>
                            <a class="btn btn-sm btn-warning"
                               href="/assignment_war_exploded/san-pham-chi-tiet/edit?id=${spct.id}&idSP=${sp.id}&mess= "">Sửa</a>
                        </td>
                        <td>
                            <button onclick="deleteById(${spct.id}, ${sp.id})" class="btn btn-sm btn-danger">Xóa</button>
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
