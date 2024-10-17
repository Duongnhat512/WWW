<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/10/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SV Form</title>
</head>
<body>
    <h2>Thông tin sinh viên</h2>
<form:form action="save" method="post">
    <table>
        <tr>
            <td>Tên:</td>
            <td><form:input path="fname" /></td>
        </tr>
        <tr>
            <td>Họ:</td>
            <td><form:input path="lname" /></td>
        </tr>
        <tr>
            <td>Điểm TB:</td>
            <td><form:input path="diemtb" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
