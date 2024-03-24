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
            if (confirm("Chuyển trạng thái sang đã hủy?")) {
                window.location.href = "http://localhost:8080/assignment_war_exploded/hoa-don/delete?id=" + id;
            }
        }
        function visiableHoaDonChiTiet(id) {
            var div = document.getElementById(id);
            div.style.display = (div.style.display === "none") ? "block" : "none";
        }
        function formatLongToDate(longValue) {
            // Tạo một đối tượng Date từ giá trị long
            var date = new Date(longValue);

            // Lấy ngày, tháng và năm từ đối tượng Date
            var day = date.getDate();
            var month = date.getMonth() + 1; // Lưu ý: Tháng bắt đầu từ 0
            var year = date.getFullYear();

            // Đảm bảo rằng ngày và tháng có hai chữ số bằng cách thêm số 0 phía trước (nếu cần)
            day = day < 10 ? '0' + day : day;
            month = month < 10 ? '0' + month : month;

            // Trả về chuỗi định dạng ngày tháng năm
            return day + '-' + month + '-' + year;
        }
    </script>
</head>

<body class="positon-relative">
<div>
    <!-- Header -->
    <div class="bg-danger container-fluid position-sticky top-0" style="z-index: 9999999;">
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
                <div class="p-2" style="background: antiquewhite">
                    <form action="/assignment_war_exploded/hoa-don/list" method="GET">
                        <label class="form-label fw-bold">Lọc trạng thái HĐ:</label>
                        <select name="tt" class="form-control">
                            <option class="text-danger" value="0">Đã hủy</option>
                            <option class="text-success" value="1">Hoàn thành</option>
                            <option class="text-secondary" value="2">Chờ giao</option>
                            <option class="text-warning" value="3">Đang giao</option>
                            <option class="text-primary" value="4">Chờ thanh toán</option>
                        </select>
                        <button class="btn text-center d-inline-block mt-2" style="background: indianred">Lọc</button>
                    </form>
                </div>
            </div>

        </div>
        <div class="w-75  mt-3">
            <div class="d-flex justify-content-between mb-3">
                <h1 class="my-2 h4 d-inline-block">Quản lý hóa đơn</h1>
                <a href="/assignment_war_exploded/hoa-don/create" class="btn btn-success m-1">Tạo hóa đơn</a>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên KH</th>
                    <th>Tên NV</th>
                    <th>Tổng SP</th>
                    <th>Tổng tiền</th>
                    <th>Ngày</th>
                    <th>Trạng thái</th>
                    <th colspan="4">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listhoadon }" var="hd">
                    <tr style="position: relative";>

                        <td>${ hd.id }</td>
                        <td>${ hd.tenKhachHang }</td>
                        <td>${ hd.tenNhanVien }</td>
                        <td>${ hd.tongSanPham }</td>
                        <td>${ hd.tongTien }</td>
                        <td style="min-width: 120px">
                            <script>
                                var date = new Date(${hd.ngayMuaHang});
                                document.write(date.getDate() + '-' + (date.getMonth()+1) + '-' + date.getFullYear());
                            </script>
                        </td>
                        <td>
                            <c:if test="${hd.trangThai == 0}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-danger border rounded me-2" style="width: 10px; height: 10px"></div>
                                    <span class="text-danger" style="font-size: 14px">Đã hủy</span>
                                </div>

                            </c:if>
                            <c:if test="${hd.trangThai == 1}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-success border rounded me-2" style="width: 10px; height: 10px"></div>
                                    <span class="text-success" style="font-size: 14px">Hoàn thành</span>
                                </div>

                            </c:if>
                            <c:if test="${hd.trangThai == 2}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-secondary border rounded me-2"
                                         style="width: 10px; height: 10px"></div>
                                    <span class="text-secondary" style="font-size: 14px">Chờ giao</span>
                                </div>
                            </c:if>
                            <c:if test="${hd.trangThai == 3}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-warning border rounded me-2" style="width: 10px; height: 10px"></div>
                                    <span class="text-warning" style="font-size: 14px">Đang giao</span>
                                </div>
                            </c:if>
                            <c:if test="${hd.trangThai == 4}">
                                <div class="d-flex align-items-center">
                                    <div class="bg-primary border rounded me-2" style="width: 10px; height: 10px"></div>
                                    <span class="text-primary" style="font-size: 14px">Chờ thanh toán</span>
                                </div>
                            </c:if>
                        </td>

                        <td class="p-1 m-0" style="width: 1px">
                            <a class="btn btn-primary btn-sm text-light"
                               href="/assignment_war_exploded/hoa-don/detail?id=${hd.id}">Xem</a>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <a class="btn btn-warning btn-sm text-light"
                               href="/assignment_war_exploded/hoa-don/edit?id=${hd.id}">Sửa</a>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <button class="btn btn-danger btn-sm text-light" onclick="deleteById(${hd.id})">Xóa</button>
                        </td>
                        <td class="p-1 m-0" style="width: 1px">
                            <button class="btn btn-secondary btn-sm text-light"
                                    onclick="visiableHoaDonChiTiet(${hd.id})">[...]
                            </button>
                                <%--Danh sách sản phẩm trong hóa đơn--%>
                            <div class="border border-danger rounded shadow bg-light" id="${hd.id}"
                                 style="display: none; position: absolute; top: 40px; right: 0; z-index: 9999; max-height: 300px; overflow-y: auto">
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
                                    <c:forEach items="${listhoadonchitiet[hd.id]}" var="hdct">
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
                                                        <span class="text-waring "
                                                              style="font-size: 14px">Đổi hàng</span>
                                                    </div>
                                                </c:if>
                                                <c:if test="${hdct.trangThai == 3}">
                                                    <div class="d-flex align-items-center">
                                                        <div class="bg-primary border rounded me-2"
                                                             style="width: 10px; height: 10px"></div>
                                                        <span class="text-primary "
                                                              style="font-size: 14px">Đang xử lý</span>
                                                    </div>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <div class="text-center py-2">
                                    <a class="btn btn-sm btn-outline-success d-inline-block"
                                       href="/assignment_war_exploded/hoa-don-chi-tiet/create?idHD=${hd.id}">Thêm</a>
                                    <a class="btn btn-sm btn-outline-warning d-inline-block"
                                       href="/assignment_war_exploded/hoa-don-chi-tiet/list?idHD=${hd.id}">Sửa</a>
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
