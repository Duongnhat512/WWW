<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 20/11/2024
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add form</title>
</head>
<body>
<div>
    <div class="header">
        <h1>IT Department</h1>
        <h2>Software Engineering</h2>
        <h1>Quản lý điện thoại</h1>
    </div>
    <div class="body-content">
        <form:form method="post" action="/process_add" modelAttribute="dienthoai">
            <form:hidden path="maDienThoai"/>
            <table>
                <tr>
                    <td>Tên điện thoại: </td>
                    <td><form:input path="tenDienThoai"/>
                        <form:errors path="tenDienThoai" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Địa chỉ: </td>
                    <td><form:input path="diaChi"/>
                        <form:errors path="diaChi" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Giá vốn: </td>
                    <td><form:input path="giaVon"/>
                        <form:errors path="giaVon" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Loại: </td>
                    <td><form:input path="loai"/>
                        <form:errors path="loai" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Nhà cung cấp: </td>
                    <td><form:input path="nhaCungCap"/>
                        <form:errors path="nhaCungCap" cssClass="error"/>
                    </td>
                </tr>
                <tr><td colspan="2"><input type="submit"></td></tr>
            </table>
        </form:form>
        <a href="/">Quay về trang chủ</a>
    </div>
    <div class="footer">

    </div>
</div>
</body>
</html>
