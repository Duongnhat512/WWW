<%--
  Created by IntelliJ IDEA.
  User: Nguyen Nhat Duong
  Date: 27/9/2024
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Tin tức</title>
</head>
<body>
<sql:setDataSource var="snapshot" user="sa" password="sapassword"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url="jdbc:sqlserver://localhost:1433;databaseName=QUANLYDANHMUC;trustServerCertificate=true"/>
<form action="/tintuc-form" method="post">
    <table>
        <tr>
            <td>Tiêu đề</td>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <td>Liên kết
            </td>
            <td>
                <input type="text" name="link" required>
                <%
//                    String text = ;
                %>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <c:if test="${not empty errorMessage}">
                    <p style="color: red;">${errorMessage}</p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Nội dung</td>
            <td><textarea name="content" rows="10" cols="30" required></textarea></td>
        </tr>
        <tr>
            <td>Danh mục</td>
            <td>
                <select name="category">
                    <c:forEach var="dm" items="${danhmucs}">
                        <option value="${dm.maDM}">${dm.tenDanhMuc}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Lưu"></td>
        </tr>
    </table>
</form>
</body>
</html>
