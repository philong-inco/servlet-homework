<%--
  Created by IntelliJ IDEA.
  User: longnvph31848
  Date: 13/03/2024
  Time: 09:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Hóa đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="mt-3 container">
    <nav class="navbar navbar-expand-sm bg-light">
        <div class="container-fluid">
            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-danger" href="http://localhost:8080/assignment_war_exploded/hoa-don">Hóa đơn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/hoa-don-chi-tiet">Hóa đơn chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/san-pham">Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/san-pham-chi-tiet">Sản phẩm chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/kich-thuoc">Kích thước</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/mau-sac">Màu sắc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/nhan-vien">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/assignment_war_exploded/khach-hang">Khách hàng</a>
                </li>
            </ul>
        </div>
    </nav>

    <h1 class="text-center my-3">Hóa Đơn</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>ID Khách hàng</th>
            <th>ID Nhân viên</th>
            <th>Ngày mua hàng</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ hoadonlist }" var="hd">
            <tr>

                <td>${ hd.id }</td>
                <td>${ hd.idKhachHang }</td>
                <td>${ hd.idNhanVien }</td>
                <td>${ hd.ngayMuaHang }</td>
                <td>${ hd.trangThai }</td>
                <td>
                    <a href="#">Sửa</a>
                </td>
                <td>
                    <a href="#">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
