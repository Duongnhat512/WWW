<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 27/9/2024
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tin tức</title>
</head>
<body>
    <table border="1px" width="100%">
        <thead>
            <tr>
                <th>Tiêu đề</th>
                <th>Liên kết</th>
                <th>Nội dung</th>
                <th>Danh mục</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listTinTuc}" var="news">
                <tr>
                    <td>${news.tieuDe}</td>
                    <td>${news.lienKet}</td>
                    <td>${news.noiDungTT}</td>
                    <td>${news.danhMuc.tenDanhMuc}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
