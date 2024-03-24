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
        document.addEventListener('DOMContentLoaded', function (){
            document.getElementById('main-form').addEventListener('submit', function (evt){
                var form = document.getElementById('main-form');
                var isValid = true;
                var mess = '';
                // Validate click checkbox mau sac
                var donGiaList = form.querySelectorAll('input[type="text"]');
                var soLuongList = form.querySelectorAll('input[type="number"]');

                donGiaList.forEach(function (donGia){
                    console.log(donGia.name + ':' + donGia.value);
                });

                donGiaList.forEach(function (donGia){
                    if (donGia.value.trim() === ''){
                        isValid = false;
                        mess = 'Vui lòng nhập đủ đơn giá';
                        donGia.classList.add('is-invalid');
                    } else if (isNaN(donGia.value) || donGia.value.charAt(0) === '.' ||donGia.value.charAt(donGia.value.length - 1) === '.'){
                        isValid = false;
                        mess = 'Đơn giá không hợp lệ';
                        donGia.classList.add('is-invalid');
                    } else if (parseFloat(donGia.value) <= 0){
                        isValid = false;
                        mess = 'Đơn giá phải lớn hơn 0';
                        donGia.classList.add('is-invalid');
                    } else {
                        donGia.classList.add('is-valid');
                        donGia.classList.remove('is-invalid');
                    }
                });

                soLuongList.forEach(function (soLuong){
                    if (soLuong.value.trim() === ''){
                        isValid = false;
                        mess = 'Vui lòng nhập đủ số lượng';
                        soLuong.classList.add('is-invalid');
                    } else if (isNaN(soLuong.value)){
                        isValid = false;
                        mess = 'Số lượng không hợp lệ';
                        soLuong.classList.add('is-invalid');
                    } else if (parseFloat(soLuong.value) < 0){
                        isValid = false;
                        mess = 'Số lượng tối thiểu phải bằng 0';
                        soLuong.classList.add('is-invalid');
                    } else {
                        soLuong.classList.add('is-valid');
                        soLuong.classList.remove('is-invalid');
                    }
                });

                console.log('isValid: ' + isValid);
                console.log('mess: ' + mess);
                if(!isValid){
                    evt.preventDefault();
                    alert(mess);
                }
            });
        });
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
            <h1 class="h4 my-3">Sửa biến thể</h1>
            <div>
                <form id="main-form" action="/assignment_war_exploded/san-pham-chi-tiet/update" method="POST">
                    <div class="mt-3">
                        <label>ID: ${bt.id}</label>
                        <input type="hidden" name="id" value="${bt.id}">
                        <input type="hidden" name="idSP" value="${sp.id}">

                    </div>
                    <div class="mt-3">
                        <label>Mã: ${bt.maSPCT}</label>
                        <input class="form-control" type="hidden" name="ma" disabled>
                    </div>
                    <div class="mt-3">
                        <label>Màu sắc:</label>
                        <select class="form-control" name="mausac">
                            <c:forEach items="${mausaclist}" var="ms">
                                <option ${(bt.idMauSac == ms.id)?"selected":""} value="${ms.id}">${ms.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mt-3">
                        <label>Kích thước:</label>
                        <select class="form-control" name="kichthuoc">
                            <c:forEach items="${kichthuoclist}" var="kt">
                                <option ${(bt.idKichThuoc == kt.id)?"selected":""} value="${kt.id}">${kt.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mt-3">
                        <input class="form-control" type="text" name="dongia" value="${bt.donGia}">
                    </div>
                    <div class="mt-3">
                        <input class="form-control" type="number" name="soluong" value="${bt.soLuong}">
                    </div>
                    <div class="mt-3">
                        <select class="form-control" name="trangthai">
                            <option ${(bt.trangThai == 1)?"selected":""} value="0">Không hoạt động</option>
                            <option ${(bt.trangThai == 1)?"selected":""} value="1">Hoạt động</option>
                        </select>
                    </div>
                    <div class="mt-3 text-center">
                        <button class="btn btn-warning">Sửa</button>
                    </div>
                    <div class="mt-3">
                       <c:if test="${mess == 1}">
                           <span class="text-danger">Biến thể đã tồn tại</span>
                       </c:if>
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
