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
    <title>Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="mt-3 container">
    <h1 class="text-center my-3">Sản phẩm</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã NV</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ sanphamlist }" var="sp">
            <tr>

                <td>${ sp.id }</td>
                <td>${ sp.ma }</td>
                <td>${ sp.ten }</td>
                <td>${ sp.trangThai }</td>

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
