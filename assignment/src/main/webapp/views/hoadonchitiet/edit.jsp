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
                var isValid = true;
                var mess = '';
                var donGia = document.getElementById('donGia');
                var trangThai = document.getElementById('trangThai');
                var soLuong = document.getElementById('soLuong');

                // Đơn giá validate
                if (donGia.value.trim() === '') {
                    donGia.classList.add('is-invalid');
                    mess = 'Vui lòng điền giá';
                    isValid = false;
                }
                else if(isNaN(donGia.value)  ||donGia.value.charAt(0) === '.' ||donGia.value.charAt(donGia.value.length - 1) === '.'){
                    donGia.classList.add('is-invalid');
                    mess = 'Giá không hợp lệ';
                    isValid = false;
                }
                else if(parseFloat(donGia.value) < 0){
                    donGia.classList.add('is-invalid');
                    mess = 'Giá không nhỏ hơn 0';
                    isValid = false;
                } else {
                    donGia.classList.add('is-valid');
                    donGia.classList.remove('is-invalid');
                }

                // Số lượng validate
                if (soLuong.value.trim() === '') {
                    soLuong.classList.add('is-invalid');
                    mess = 'Vui lòng điền số lượng';
                    isValid = false;
                }
                else if(isNaN(soLuong.value)){
                    soLuong.classList.add('is-invalid');
                    mess = 'Số lượng không hợp lệ';
                    isValid = false;
                }
                else if(parseFloat(soLuong.value) % 1 != 0){
                    console.log('Result: ' + parseFloat(soLuong) % 1 != 0)
                    soLuong.classList.add('is-invalid');
                    mess = 'Số lượng phải là số nguyên';
                    isValid = false;
                }
                else if(parseFloat(soLuong.value) < 0){
                    soLuong.classList.add('is-invalid');
                    mess = 'Số lượng không nhỏ hơn 0';
                    isValid = false;
                }else {
                    soLuong.classList.add('is-valid');
                    soLuong.classList.remove('is-invalid');
                }

                //Trang thai validate
                if (trangThai.value.trim() === '') {
                    trangThai.classList.add('is-invalid');
                    mess = 'Vui lòng chọn trạng thái';
                    isValid = false;
                } else {
                    trangThai.classList.add('is-valid');
                    trangThai.classList.remove('is-invalid');
                }

                console.log('isValid: ' + isValid);
                console.log('mess: ' + mess);
                if(!isValid){
                    evt.preventDefault();
                    alert(mess);
                }
            });
        });

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
        </div>
        <div class="w-75  mt-3">

            <div class="mt-3">
                <h3 class="h4">Sửa sản phẩm trong hóa đơn:</h3>
                <form id="main-form" action="/assignment_war_exploded/hoa-don-chi-tiet/update" method="POST">
                    <div class="mt-3">
                        <label class="form-label">ID Hóa đơn: ${hdct.idHoaDon}</label>
                        <input class="form-control" type="hidden" name="idHD" value="${hdct.idHoaDon}">
                        <input class="form-control" type="hidden" name="id" value="${hdct.id}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Đơn giá</label>
                        <input id="donGia" class="form-control" type="text" name="dongia" value="${hdct.donGia}">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Số lượng</label>
                        <input id="soLuong" class="form-control" type="number" name="soluong" value="${hdct.soLuong}">
                    </div>

                    <div class="mt-3">
                        <label class="form-label">Trạng thái</label>
                        <select id="trangThai" class="form-control" name="trangthai" class="form-label">
                            <option ${(hdct.trangThai == 0)?"selected": ""} value="0">Trả hàng/Hoàn tiền</option>
                            <option ${(hdct.trangThai == 1)?"selected": ""} value="1">Giao thành công</option>
                            <option ${(hdct.trangThai == 2)?"selected": ""} value="2">Đổi hàng</option>
                            <option ${(hdct.trangThai == 3)?"selected": ""} value="3">Đang xử lý</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Sản phẩm: <span class="fw-bold">${hdct.tenSanPham}</span> <span class="text-primary fw-bold">[${hdct.tenMau} -  ${hdct.tenKichThuoc}]</span></label>
                        <div style="background: cornflowerblue; cursor: pointer;" class="p-2 d-inline-block border rounded" onclick="visableHDCT()">Chọn sản phẩm</div>
                        <%--Danh sách sản phẩm--%>
                        <div class="border border-danger rounded shadow bg-light" id="divHDCT"
                             style="display: none; position: absolute; bottom: 120px; right: 20px; z-index: 9999; max-height: 300px; overflow-y: auto;">
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
                                            <c:if test="${spct.trangThai == 0}">
                                                <div class="d-flex align-items-center">
                                                    <div class="bg-danger border rounded me-2"
                                                         style="width: 10px; height: 10px"></div>
                                                    <span class="text-danger"
                                                          style="font-size: 14px">Trả hàng/Hoàn tiền</span>
                                                </div>

                                            </c:if>
                                            <c:if test="${spct.trangThai == 1}">
                                                <div class="d-flex align-items-center">
                                                    <div class="bg-success border rounded me-2"
                                                         style="width: 10px; height: 10px"></div>
                                                    <span class="text-success "
                                                          style="font-size: 14px">Giao thành công</span>
                                                </div>
                                            </c:if>
                                            <c:if test="${spct.trangThai == 2}">
                                                <div class="d-flex align-items-center">
                                                    <div class="bg-warning border rounded me-2"
                                                         style="width: 10px; height: 10px"></div>
                                                    <span class="text-warning"
                                                          style="font-size: 14px">Đổi hàng</span>
                                                </div>
                                            </c:if>
                                            <c:if test="${spct.trangThai == 3}">
                                                <div class="d-flex align-items-center">
                                                    <div class="bg-secondary border rounded me-2"
                                                         style="width: 10px; height: 10px"></div>
                                                    <span class="text-secondary"
                                                          style="font-size: 14px">Đang xử lý</span>
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
