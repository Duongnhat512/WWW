<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/10/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View SV</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="2" width="70%" cellspacing="0">
    <tr>
        <th>MSSV</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Diem TB</th>
    </tr>
    <c:forEach items="${list}" var="sv">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.fname}</td>
            <td>${sv.lname}</td>
            <td>${sv.diemtb}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
