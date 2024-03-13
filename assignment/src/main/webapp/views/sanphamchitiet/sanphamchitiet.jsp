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
    <title>Sản phẩm chi tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="mt-3 container">
    <h1 class="text-center my-3">Sản phẩm chi tiết</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã SPCT</th>
            <th>ID kích thước</th>
            <th>ID màu sắc</th>
            <th>ID sản phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ sanphamchitietlist }" var="spct">
            <tr>

                <td>${ spct.id }</td>
                <td>${ spct.maSPCT }</td>
                <td>${ spct.idKichThuoc }</td>
                <td>${ spct.idMauSac }</td>
                <td>${ spct.idSanPham }</td>
                <td>${ spct.soLuong }</td>
                <td>${ spct.donGia }</td>
                <td>${ spct.trangThai }</td>

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
