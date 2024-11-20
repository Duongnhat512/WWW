<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 20/11/2024
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .wrapper {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <h1>IT Department</h1>
        <h2>Software Engineering</h2>
        <h1>Quản lý điện thoại</h1>
    </div>
    <div class="body-content">
        <a href="/show_add_form">Thêm điện thoại </a> |
        <table border="1">
            <tr>
                <td>Tên điện thoại</td>
                <td>Địa chỉ</td>
                <td>Giá vốn</td>
                <td>Loại</td>
                <td>Nhà cung cấp</td>
                <td>Chức năng</td>
            </tr>
            <c:forEach items="${dienthoais}" var='dienthoai'>
                <tr>
                    <td>${dienthoai.tenDienThoai}</td>
                    <td>${dienthoai.diaChi}</td>
                    <td>${dienthoai.giaVon}</td>
                    <td>${dienthoai.loai}</td>
                    <td>${dienthoai.nhaCungCap}</td>
                    <td>
                        <a href="/show_update_form?id=${dienthoai.maDienThoai}">Sửa</a> |
                        <a href="/delete?id=${dienthoai.maDienThoai}"
                            onclick='if (!(confirm("Bạn có muốn xóa điện thoại này không?"))) return false'>Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="footer">

    </div>
</div>
</body>
</html>
