<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 27/9/2024
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý form</title>
</head>
<body>
<table border="1px" width="100%">
    <table border="1px" width="100%">
        <thead>
        <tr>
            <th>Tiêu đề</th>
            <th>Liên kết</th>
            <th>Nội dung</th>
            <th>Danh mục</th>
            <th>Lựa chọn</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listTinTuc}" var="news">
            <tr>
                <td>${news.tieuDe}</td>
                <td>${news.lienKet}</td>
                <td>${news.noiDungTT}</td>
                <td>
                    ${news.danhMuc.tenDanhMuc}
                </td>
                <td><a href="${pageContext.request.contextPath}/quanly-form?action=delete&id=${news.maTT}"
                       onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
