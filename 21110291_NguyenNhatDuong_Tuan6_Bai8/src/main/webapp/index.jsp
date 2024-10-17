<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<style>
    a{
        text-decoration: none;
        color: black;
        font-size: 20px;
    }
</style>
<body>
<div class="container">
    <img src="/resources/images/img.png" alt="image" style="width: 100%">
    <div style="display: flex;justify-content: center; gap: 15px">
        <a href="${pageContext.request.contextPath}/phone">Danh sách sản phẩm</a>
        <a href="${pageContext.request.contextPath}/phone?action=new">Thêm moi sản phẩm</a>
        <a href="${pageContext.request.contextPath}/phone">Chức năng quản lý</a>
    </div>
</div>
</body>
</html>