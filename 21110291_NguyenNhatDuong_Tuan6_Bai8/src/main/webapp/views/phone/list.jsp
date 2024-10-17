<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/10/2024
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách diện thoại</title>
</head>
<style>
    .card {
        border: 1px solid #ccc;
        border-radius: 5px;
        padding: 10px;
        margin: 10px;
        width: 300px;
        float: left;
    }
</style>
<body>
<h1>Danh sách diện thoại</h1>
<h4>
    <a href="${pageContext.request.contextPath}/phone?action=new">Add điện thoại</a> &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/phone">Danh sách điện thoại</a>
</h4>
<c:forEach items="${dienThoais}" var="dt">
    <div class="card">
        <p>${dt.tenDT}</p>
        <p>${dt.namSanXuat}</p>
        <p>${dt.cauHinh}</p>
        <p>${dt.nhaCC.tenNhaCC}</p>
        <a href="${pageContext.request.contextPath}/phone?action=edit&txtId=${dt.maDT}">Edit</a>
        <a href="${pageContext.request.contextPath}/phone?action=delete&txtId=${dt.maDT}"
            onclick="return confirm('Bạn có chắc muốn xóa không?')">Delete</a>
    </div>
</c:forEach>
</body>
</html>
