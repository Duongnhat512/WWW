<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
    <title>Add Phone</title>
</head>
<body>
<div>
    <h2>Quản lý điện thoại</h2>
    <h4>
        <a href="${pageContext.request.contextPath}/phone?action=new">Add điện thoại</a> &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/phone">Danh sách điện thoại</a>
    </h4>

    <h2>Add new phone</h2>
    <form action="/phone?action=insert" method="post">
        <table>
            <input type="hidden" name="txtId">
            <tr>
                <th>Tên điện thoại:</th>
                <td>
                    <input type="text" name="txtTenDT" maxlength="50" size="50">
                </td>
            </tr>
            <tr>
                <th>Năm sản xuất:</th>
                <td>
                    <input type="text" name="txtNamSanXuat" maxlength="4" size="4">
                </td>
            </tr>
            <tr>
                <th>Cấu hình:</th>
                <td>
                    <input type="text" name="txtCauHinh" maxlength="20" size="15">
                </td>
            </tr>
            <tr>
                <th>Nhà cung cấp</th>
                <td>
                    <input type="text" name="txtMaNCC" maxlength="20" size="15">
                </td>
            </tr>
            <tr>
                <td colspan="2", align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
