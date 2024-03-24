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
                var user = document.getElementById('user');
                var pass = document.getElementById('pass');
                var isValid = true;
                var mess = '';

                if (user.value.trim() === ''){
                    isValid = false;
                    mess = 'Vui lòng điền tên đăng nhập';
                    user.classList.add('is-invalid');
                } else {
                    user.classList.remove('is-invalid');
                    user.classList.add('is-valid');
                }

                if (pass.value.trim() === ''){
                    isValid = false;
                    mess = 'Vui lòng điền tên mật khẩu';
                    pass.classList.add('is-invalid');
                } else {
                    pass.classList.remove('is-invalid');
                    pass.classList.add('is-valid');
                }

                if (user.value.trim().includes(' ')){
                    isValid = false;
                    mess = 'Tên đăng nhập không được chứa dấu cách';
                    user.classList.add('is-invalid');
                } else {
                    user.classList.remove('is-invalid');
                    user.classList.add('is-valid');
                }

                if (pass.value.trim().includes(' ')){
                    isValid = false;
                    mess = 'Mật khâu không được chứa dấu cách';
                    pass.classList.add('is-invalid');
                } else {
                    pass.classList.remove('is-invalid');
                    pass.classList.add('is-valid');
                }


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
    <div class="bg-danger container-fluid position-sticky top-0 m-0 p-0">
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


        <div style="min-height: 430px; background: blanchedalmond" class="d-flex justify-content-center align-content-center m-0 p-0">
            <div class="w-25 bg-white border rounded p-3 m-5 shadow" style="max-height: 350px">
                <form id="main-form" action="/assignment_war_exploded/success" method="POST">
                    <div class="mt-3">
                        <label class="form-label">Tên đăng nhập:</label>
                        <input id="user" class="form-control" type="text" name="username">
                    </div>
                    <div class="mt-3">
                        <label class="form-label">Mật khẩu:</label>
                        <input id="pass" class="form-control" type="password" name="password">
                    </div>
                    <div class="mt-3 text-center">
                        <button class="btn btn-primary">Đăng nhập</button>
                    </div>
                    <div class="mt-3">
                        <c:if test="${check == 0}">
                            <span class="text-danger">Đăng nhập thất bại!</span>
                        </c:if>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <!-- Footer -->
    <div class="bg-dark py-3 text-center">
        <span class="text-light my-2">longnvph31848 - Nguyễn Vĩnh Long</span>
    </div>
</div>
</body>

</html>