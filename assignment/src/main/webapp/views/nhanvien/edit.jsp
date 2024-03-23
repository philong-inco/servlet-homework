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
                var isValid = true;
                var mess = '';
                var ten = document.getElementById('ten');
                var trangThai = document.getElementById('trangThai');
                var userName = document.getElementById('userName');
                var matKhau = document.getElementById('matKhau');

                // Ten validate
                if (ten.value.trim() === ''){
                    ten.classList.add('is-invalid');
                    mess = 'Vui lòng điền tên';
                    isValid = false;
                } else {
                    ten.classList.add('is-valid');
                    ten.classList.remove('is-invalid');
                }

                if (ten.value.trim().length > 255){
                    ten.classList.add('is-invalid');
                    mess = 'Tên quá số ký tự (255)';
                    isValid = false;
                }

                // User validate
                if (userName.value.trim() === ''){
                    userName.classList.add('is-invalid');
                    mess = 'Vui lòng điền username';
                    isValid = false;
                } else {
                    userName.classList.add('is-valid');
                    userName.classList.remove('is-invalid');
                }
                if (userName.value.trim().includes(' ')){
                    userName.classList.add('is-invalid');
                    mess = 'Username không được chứa dấu cách';
                    isValid = false;
                }

                if (userName.value.trim().length > 16){
                    userName.classList.add('is-invalid');
                    mess = 'Username được phép tối đa 16 ký tự (16)';
                    isValid = false;
                }

                // Matkhau validate
                if (matKhau.value.trim() === ''){
                    matKhau.classList.add('is-invalid');
                    mess = 'Vui lòng điền mật khẩu';
                    isValid = false;
                } else {
                    matKhau.classList.add('is-valid');
                    matKhau.classList.remove('is-invalid');
                }
                if (matKhau.value.trim().includes(' ')){
                    matKhau.classList.add('is-invalid');
                    mess = 'Mật khẩu không được chứa dấu cách';
                    isValid = false;
                }

                if (matKhau.value.trim().length > 16){
                    matKhau.classList.add('is-invalid');
                    mess = 'Mật khẩu được phép tối đa 16 ký tự (16)';
                    isValid = false;
                }

                // TrangThai validate
                if (trangThai.value.trim() === ''){
                    trangThai.classList.add('is-invalid');
                    mess = 'Vui lòng chọn trạng thái';
                    isValid = false;
                } else {
                    trangThai.classList.add('is-valid');
                    trangThai.classList.remove('is-invalid');
                }
                console.log('isValid: ' + isValid);
                if (!isValid){
                    evt.preventDefault();
                    alert(mess);
                }
            });
        });
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
                <h1 class="my-2 h4 d-inline-block">Sửa nhân viên</h1>
                <a href="/assignment_war_exploded/nhan-vien/list" class="btn btn-secondary m-1">Danh sách nhân viên</a>
            </div>
            <div>
                <form id="main-form" method="POST" action="/assignment_war_exploded/nhan-vien/update">
                    <div class="mt-3">
                        <label class="form-label">ID nhân viên: ${nv.id}</label>
                        <input class="form-control" type="hidden" name="id" value="${nv.id}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Mã nhân viên: ${nv.maNV}</label>
                        <input class="form-control" type="hidden" name="ma" value="${nv.maNV}" placeholder="Nhập mã nhân viên">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Tên nhân viên:</label>
                        <input id="ten" class="form-control" type="text" name="ten" value="${nv.ten}" placeholder="Nhập tên nhân viên">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Username:</label>
                        <input id="userName" class="form-control" type="text" name="username" value="${nv.tenDangNhap}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Mật khẩu:</label>
                        <input id="matKhau" class="form-control" type="text" name="matkhau" value="${nv.matKhau}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Trạng thái:</label>
                        <select id="trangThai" class="form-control" name="trangthai" >
                            <option class="text-secondary" value="">-- Lựa chọn --</option>
                            <option ${nv.trangThai == 1 ? "selected" : ""} class="text-success" value="1">Hoạt động</option>
                            <option ${nv.trangThai == 0 ? "selected" : ""} class="text-danger" value="0">Không hoạt động</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <button class="btn btn-primary">Sửa</button>
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