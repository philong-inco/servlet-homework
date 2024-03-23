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
                window.location.href = "http://localhost:8080/assignment_war_exploded/hoa-don-chi-tiet/delete?id=" + id;
            }
        }

        function visableHDCT() {
            var divHDCT = document.getElementById("divHDCT");
            divHDCT.style.display = (divHDCT.style.display === "none") ? "block" : "none";
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
        </div>
        <div class="w-75  mt-3">
            <div>
                <div class="d-flex justify-content-between mb-3">
                    <h1 class="my-2 h4 d-inline-block">Sản phẩm trong hóa đơn ID: ${id}</h1>
                </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên sản phẩm</th>
                        <th>Màu</th>
                        <th>Kích thước</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Trạng thái</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listHDCT}" var="hdct">
                        <tr>
                            <td>${hdct.id}</td>
                            <td>${hdct.tenSanPham}</td>
                            <td>${hdct.tenMau}</td>
                            <td>${hdct.tenKichThuoc}</td>
                            <td>${hdct.donGia}</td>
                            <td>${hdct.soLuong}</td>
                            <td>
                                <c:if test="${hdct.trangThai == 0}">
                                    <div class="d-flex align-items-center">
                                        <div class="bg-danger border rounded me-2"
                                             style="width: 10px; height: 10px"></div>
                                        <span class="text-danger" style="font-size: 14px">Trả hàng/Hoàn tiền</span>
                                    </div>
                                </c:if>
                                <c:if test="${hdct.trangThai == 1}">
                                    <div class="d-flex align-items-center">
                                        <div class="bg-success border rounded me-2"
                                             style="width: 10px; height: 10px"></div>
                                        <span class="text-success "
                                              style="font-size: 14px">Giao thành công</span>
                                    </div>

                                </c:if>
                                <c:if test="${hdct.trangThai == 2}">
                                    <div class="d-flex align-items-center">
                                        <div class="bg-warning border rounded me-2"
                                             style="width: 10px; height: 10px"></div>
                                        <span class="text-warning" style="font-size: 14px">Đổi hàng</span>
                                    </div>
                                </c:if>
                                <c:if test="${hdct.trangThai == 3}">
                                    <div class="d-flex align-items-center">
                                        <div class="bg-primary border rounded me-2"
                                             style="width: 10px; height: 10px"></div>
                                        <span class="text-primary" style="font-size: 14px">Đang xử lý</span>
                                    </div>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <div class="mt-3">
                <h3 class="h4">Thêm sản phẩm vào hóa đơn:</h3>
                <form action="/assignment_war_exploded/hoa-don-chi-tiet/store" method="POST">
                    <div class="mt-3">
                        <label class="form-label">ID Hóa đơn: ${id}</label>
                        <input class="form-control" type="hidden" name="idHD" value="${id}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Đơn giá</label>
                        <input class="form-control" type="text" name="dongia">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Số lượng</label>
                        <input class="form-control" type="text" name="soluong">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Trạng thái</label>
                        <select class="form-control" name="trangthai" class="form-label">
                            <option value="1">Hoạt động</option>
                            <option value="0">Không hoạt động</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Sản phẩm:</label>
                        <div class="p-2 d-inline-block bg-primary" onclick="visableHDCT()">Chọn sản phẩm</div>
                        <%--Danh sách sản phẩm--%>
                        <div class="border border-danger rounded shadow bg-light" id="divHDCT"
                             style="display: none; position: absolute; bottom: 0px; right: 20px; z-index: 9999; max-height: 700px; overflow-y: auto;">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Chọn</th>
                                    <th>Tên SP</th>
                                    <th>Màu</th>
                                    <th>Kích thước</th>
                                    <th>Số lượng</th>
                                    <th>Đơn giá</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listSPCT}" var="spct">
                                    <tr>
                                        <td>
                                            <input type="radio" name="idSPCT" value="${spct.id}">
                                        </td>
                                        <td>${spct.tenSanPham}</td>
                                        <td>${spct.mauSac}</td>
                                        <td>${spct.kichThuoc}</td>
                                        <td>${spct.soLuong}</td>
                                        <td>${spct.donGia}</td>
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
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>

                    <div class="mt-3">
                        <button class="btn btn-success">Thêm</button>
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
