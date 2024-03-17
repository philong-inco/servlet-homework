<%--
  Created by IntelliJ IDEA.
  User: longnvph31848
  Date: 15/03/2024
  Time: 04:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var check = false;
        function click(){
            check = !check;
        }
    </script>
</head>
<body>
    <h1>Test hiển thị click</h1>
    <button onclick="click()">Hiện ra</button>
    <c:if test="check">
        <button>Kết quả</button>
    </c:if>
</body>
</html>
