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
            <div class="d-flex justify-content-between mb-3">
                <h1 class="my-2 h4 d-inline-block">Chi tiết Hóa đơn</h1>
                <a href="/assignment_war_exploded/hoa-don/list" class="btn btn-secondary m-1">Danh sách Hóa đơn</a>
            </div>
            <div>
                <form method="GET" action="/assignment_war_exploded/hoa-don/edit?${hd.id}">
                    <div class="mt-3">
                        <label class="form-label">ID Hóa đơn: ${hd.id}</label>
                        <input class="form-control" type="hidden" name="id" value="${hd.id}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Khách hàng:</label>
                        <input class="form-control" type="text" name="kh" value="${hd.tenKhachHang} (${hd.sdtKhachHang})" disabled>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Tên nhân viên:</label>
                        <input class="form-control" type="text" name="nv" value="${hd.tenNhanVien}" disabled>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Tổng sản phẩm: <span class="fw-bold">${hd.tongSanPham}</span></label><br>
                        <label class="form-label">Tổng tiền: <span class="fw-bold">${hd.tongTien}</span></label><br>
                        <label class="form-label">Ngày mua hàng: <span class="fw-bold">${hd.ngayMuaHang}</span></label>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Trạng thái:</label>
                        <select class="form-control" name="trangthai" disabled>
                            <option class="text-secondary" value="">-- Lựa chọn --</option>
                            <option ${hd.trangThai == 1 ? "selected" : ""} class="text-success" value="1">Hoàn thành</option>
                            <option ${hd.trangThai == 0 ? "selected" : ""} class="text-danger" value="0">Đã hủy</option>
                            <option ${hd.trangThai == 2 ? "selected" : ""} class="text-secondary" value="2">Chờ giao</option>
                            <option ${hd.trangThai == 3 ? "selected" : ""} class="text-warning" value="3">Đang giao</option>
                            <option ${hd.trangThai == 4 ? "selected" : ""} class="text-primary" value="4">Chờ thanh toán</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <h3 class="h6 mt-3">Danh sách sản phẩm trong hóa đơn:</h3>
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
                            <c:forEach items="${hdct}" var="hdct">
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
                                                <span class="text-warning "
                                                      style="font-size: 14px">Đổi hàng</span>
                                            </div>
                                        </c:if>
                                        <c:if test="${hdct.trangThai == 3}">
                                            <div class="d-flex align-items-center">
                                                <div class="bg-primary border rounded me-2"
                                                     style="width: 10px; height: 10px"></div>
                                                <span class="text-primary"
                                                      style="font-size: 14px">Đang xử lý</span>
                                            </div>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
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