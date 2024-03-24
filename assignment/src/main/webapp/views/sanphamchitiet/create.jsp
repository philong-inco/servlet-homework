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
            <div class="d-flex justify-content-between mb-3">
                <h1 class="my-2 h4 d-inline-block">Thêm mới biến thể</h1>
                <a href="/assignment_war_exploded/san-pham/list" class="btn btn-secondary m-1">Danh sách sản phẩm</a>
            </div>
            <div>
                <form id="main-form" method="POST" action="/assignment_war_exploded/san-pham-chi-tiet/store">
                    <div class="mt-3">
                        <label class="form-label">Tên sản phẩm: <span class="text-danger">${sp.ten}</span></label>
                        <input class="form-control" type="hidden" name="idSP" value="${sp.id}">
                    </div>
                    <h2 class="h4">Vui lòng điền đủ thông tin các trường</h2>


                    <c:forEach items="${listrender}" var="o" varStatus="loop">
                        <div class="border shadow my-3 p-1 d-flex">
                            <div class="w-25 pb-2">
                                <div class="p-1 mt-1 border rounded" style="background: darksalmon">
                                    <label>Màu: ${o.mauSac}</label>
                                </div>
                                <div class="p-1 mt-1 border rounded" style="background: indianred">
                                    <label>Kích thước: ${o.kichThuoc}</label>
                                </div>
                                <input type="hidden" name="idMauSac_${loop.index}" value="${o.idMauSac}">
                                <input type="hidden" name="idKichThuoc_${loop.index}" value="${o.idKichThuoc}">
                            </div>
                            <div class="w-75 d-flex align-items-center">
                                <div style="width: 30%" class="p-2 mx-1">
                                    <label>Đơn giá</label>
                                    <input type="text" name="donGia_${loop.index}" value="${o.donGia}">
                                </div>
                                <div style="width: 30%" class="p-2 mx-1">
                                    <label>Số lượng</label>
                                    <input type="number" name="soLuong_${loop.index}" value="${o.soLuong}">
                                </div>
                                <div style="width: 30%" class="p-2 mx-1">
                                    <label>Trạng thái</label>
                                    <select name="trangThai_${loop.index}">
                                        <option ${(o.trangThai == 1)?"selected":""} value="1">Hoạt động</option>
                                        <option ${(o.trangThai == 0)?"selected":""} value="0">Không hoạt động</option>
                                    </select>

                                </div>
                            </div>

                        </div>
                    </c:forEach>

                    <div class="mt-3 text-center">
                        <button class="btn btn-success">Hoàn thành</button>
                    </div>
                </form>

                <div>
                    <c:if test="${sizeExist != 0}">
                        <%--List tồn tại--%>
                        <h4 class="h5 text-danger">Danh sách biến thể đã tồn tại (không thêm mới)</h4>
                        <c:forEach items="${listexist}" var="o">
                            <div class="border shadow my-3 p-1 d-flex" style="color: darkgray">
                                <div class="w-25 pb-2">
                                    <div class="p-1 mt-1">
                                        <label>Màu: ${o.mauSac}</label>
                                    </div>
                                    <div class="p-1 mt-1">
                                        <label>Kích thước: ${o.kichThuoc}</label>
                                    </div>
                                    <input type="hidden"  value="${o.idMauSac}" disabled>
                                    <input type="hidden"  value="${o.idKichThuoc}" disabled>
                                </div>
                                <div class="w-75 d-flex align-items-center">
                                    <div style="width: 30%" class="p-2 mx-1">
                                        <label>Đơn giá</label>
                                        <input type="text" value="${o.donGia}" disabled>
                                    </div>
                                    <div style="width: 30%" class="p-2 mx-1">
                                        <label>Số lượng</label>
                                        <input type="text" value="${o.soLuong}" disabled>
                                    </div>
                                    <div style="width: 30%" class="p-2 mx-1">
                                        <label>Trạng thái</label>
                                        <select disabled>
                                            <option ${(o.trangThai == 1)?"selected":""} value="1">Hoạt động</option>
                                            <option ${(o.trangThai == 0)?"selected":""} value="0">Không hoạt động</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </c:forEach>
                    </c:if>
                </div>
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