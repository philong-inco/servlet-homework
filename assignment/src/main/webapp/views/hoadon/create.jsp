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
                var divKhachHang = document.getElementById('divkhachhang');
                var divNhanVien = document.getElementById('divnhanvien');
                var divSPCT = document.getElementById('divSPCT');
                var trangThai = document.getElementById('trangThai');

                var isValid = true;
                var mess = '';

                var khachHangList = divKhachHang.querySelectorAll('input[name="idKH"]');
                var nhanVienList = divNhanVien.querySelectorAll('input[name="idNV"]');
                var spctList = divSPCT.querySelectorAll('input[type="number"]');

                var checked = false;
                if (trangThai.value === ''){
                    isValid = false;
                    mess = 'Vui lòng chọn trạng thái';
                    trangThai.classList.add('is-invalid');
                } else {
                    khachHangList.forEach(function (kh){
                        if (kh.checked){
                            checked = true;
                        }
                    });
                    if (!checked){
                        isValid = false;
                        mess = 'Vui lòng chọn khách hàng \n';
                    }

                    checked = false;
                    nhanVienList.forEach(function (nv){
                        if (nv.checked){
                            checked = true;
                        }
                    });

                    if (!checked){
                        isValid = false;
                        mess += 'Vui lòng chọn nhân viên \n';
                    }

                    checked = false;
                    spctList.forEach(function (spct){
                        if (parseInt(spct.value) != 0){
                            checked = true;
                        }
                    });
                    if (!checked){
                        isValid = false;
                        mess += 'Vui lòng chọn tối thiểu 1 sản phẩm \n';
                    }
                }

                if (!isValid){
                    evt.preventDefault();
                    alert(mess);
                }

            });
        });

        function visiableNhanVien() {
            var divNV = document.getElementById("divnhanvien");
            divNV.style.display = (divNV.style.display === "none") ? "block" : "none";
        }
        function visiableKhachHang() {
            var divKH = document.getElementById("divkhachhang");
            divKH.style.display = (divKH.style.display === "none") ? "block" : "none";
        }
        function visiableSPCT() {
            var divSPCT = document.getElementById("divSPCT");
            divSPCT.style.display = (divSPCT.style.display === "none") ? "block" : "none";
        }
        function tang(id){
            console.log('ID: ' + id);
            let indexStr = id.toString();
            let index = indexStr.substring(indexStr.lastIndexOf('-') + 1);
            console.log(index);
            var tonKho = document.getElementById('tonkho-' + index);
            var tonKhoValue = parseInt(tonKho.value);
            console.log('Tồn kho: '+tonKhoValue);
            var soLuong = document.getElementById('soluong-' + index);
            var soLuongValue = parseInt(soLuong.value);
            soLuongValue = isNaN(soLuongValue) ? 0: soLuongValue;
            console.log('Số lượng: ' + soLuongValue);
            if (soLuongValue < tonKhoValue){
                console.log('true');
                soLuong.value = soLuongValue +  1;
                console.log('Change: '+soLuong.value);
            }
        }
        function giam(id){
            console.log('ID: ' + id);
            let indexStr = id.toString();
            let index = indexStr.substring(indexStr.lastIndexOf('-') + 1);
            // var tonKho = document.getElementById('tonkho-' + index);
            // var tonKhoValue = parseInt(tonKho.value);
            var soLuong = document.getElementById('soluong-' + index);
            var soLuongValue = parseInt(soLuong.value);
            if (soLuongValue > 0){
                soLuong.value = soLuongValue -  1;
            }
        }

    </script>
</head>

<body>
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
                <h1 class="my-2 h4 d-inline-block">Thêm hóa đơn</h1>
                <a href="/assignment_war_exploded/hoa-don/list" class="btn btn-secondary m-1">Danh sách Hóa đơn</a>
            </div>
            <div>
                <form id="main-form" method="POST" action="/assignment_war_exploded/hoa-don/store" >
                    <div class="mt-3" style="position: relative;">
                        <label class="form-label">Tên khách hàng:</label>
                        <div style="background: cornflowerblue; cursor: pointer;" class="p-2 d-inline-block border rounded mb-1" onclick="visiableKhachHang()">Chọn khách hàng</div>
                        <%--Danh sách khách hàng--%>
                        <div class="border border-danger rounded shadow bg-light" id="divkhachhang"
                             style="display: none; position: absolute; top: 0; right: -46px; z-index: 9999;  max-height: 700px; overflow-y: auto;">
                            <h5 class="h6 mt-2 text-center">Danh sách khách hàng</h5>
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Chọn</th>
                                    <th>Mã</th>
                                    <th>Tên KH</th>
                                    <th>SĐT</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listkhachhang}" var="kh">
                                    <tr>
                                        <td>
                                            <input type="radio" name="idKH" value="${kh.id}">
                                        </td>
                                        <td>${kh.maKH}</td>
                                        <td>${kh.ten}</td>
                                        <td>${kh.sdt}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="mt-3" style="position: relative;">
                        <label class="form-label">Nhân viên:</label>
                        <div style="background: darksalmon; cursor: pointer;" class="p-2 d-inline-block border rounded mb-1" onclick="visiableNhanVien()">Chọn nhân viên</div>
                        <%--Danh sách nhân viên--%>
                        <div class="border border-danger rounded shadow bg-light" id="divnhanvien"
                             style="display: none; position: absolute; bottom: -89px; right: -50px; z-index: 9999; max-height: 700px; overflow-y: auto;">
                            <h5 class="h6 mt-2 text-center">Danh sách nhân viên</h5>
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Chọn</th>
                                    <th>Mã NV</th>
                                    <th>Tên NV</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listnhanvien}" var="nv">
                                    <tr>
                                        <td>
                                            <input type="radio" name="idNV" value="${nv.id}">
                                        </td>
                                        <td>${nv.maNV}</td>
                                        <td>${nv.ten}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="mt-3">
                        <label class="form-label">Trạng thái:</label>
                        <select id="trangThai" class="form-control" name="trangthai">
                            <option class="text-secondary" value="">-- Lựa chọn --</option>
                            <option class="text-success" value="1">Hoàn thành</option>
                            <option class="text-danger" value="0">Đã hủy</option>
                            <option class="text-secondary" value="2">Chờ giao</option>
                            <option class="text-warning" value="3">Đang giao</option>
                            <option class="text-primary" value="4">Chờ thanh toán</option>
                        </select>
                    </div>

                    <div class="mt-3" style="position: relative;">
                        <label class="form-label">Sản phẩm:</label>
                        <div style="background: darksalmon; cursor: pointer;" class="p-2 d-inline-block border rounded mb-1" onclick="visiableSPCT()">Chọn sản phẩm</div>
                        <%--Danh sách sản phẩm chi tiết--%>
                        <div class="border border-danger rounded shadow bg-light" id="divSPCT"
                             style="display: none; position: absolute; bottom: -82px; right: -59px; z-index: 9999; max-height: 400px; overflow-y: auto;">
                            <h5 class="h6 mt-2 text-center">Danh sách sản phẩm</h5>
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Sản phẩm</th>
                                    <th>Tồn kho</th>
                                    <th>Số lượng</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listsanphamchitiet}" var="spct" varStatus="loop">
                                    <tr>
                                        <td>
                                            <input type="hidden" name="idSPCT_${loop.index}" value="${spct.id}">
                                            <span class="fw-bold">${spct.tenSanPham}</span>
                                            <span class="text-danger">[${spct.mauSac} - ${spct.kichThuoc}]</span>
                                        </td>
                                        <td >${spct.soLuong}</td>
                                        <td  class="d-flex">
                                            <input id="tonkho-${loop.index}" type="hidden" value="${spct.soLuong}" disabled>
                                            <input  type="hidden" name="dongia_${loop.index}" value="${spct.donGia}">
                                            <input class="me-2" id="soluong-${loop.index}" style="width: 50px" type="number" name="soluong_${loop.index}" value="0" min="0" max="${spct.soLuong}" readonly>
                                            <div class="d-flex me-2">
                                                <div id="tang-${loop.index}" class="me-2 px-2 text-dark border rounded" style="cursor: pointer; background: aquamarine" onclick="tang(this.id)">+</div>
                                                <div id="giam-${loop.index}" class="me-1 px-2 text-dark border rounded" style="cursor: pointer; background: indianred" onclick="giam(this.id)">-</div>
                                            </div>

                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="mt-3">
                        <button class="btn btn-warning">Tạo hóa đơn</button>
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