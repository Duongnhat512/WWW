<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Giảng viên - Đề tài</title>
</head>
<body>
<sql:setDataSource var="snapshot" user="sa" password="sapassword"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url="jdbc:sqlserver://localhost:1433;databaseName=QLDT;encrypt=true;trustServerCertificate=true"/>
<%--Insert Data--%>
<sql:update dataSource = "${snapshot}" var = "result">
    INSERT INTO GIANGVIEN VALUES ('GV0007', 'Thanh Van', 'Lĩnh vực', '0011223344');
</sql:update>
<%--Delete Data--%>
<c:set var = "gvId" value = "GV0007"/>
<sql:update dataSource = "${snapshot}" var = "count">
    DELETE FROM GIANGVIEN WHERE MAGV = ?
    <sql:param value = "${gvId}" />
</sql:update>
<%--Update Data--%>
<c:set var = "gvId" value = "GV0007"/>
<sql:update dataSource = "${snapshot}" var = "count">
    UPDATE GIANGVIEN SET TENGV = 'Van' WHERE MAGV=?;
    <sql:param value = "${gvId}" />
</sql:update>
<sql:query dataSource="${snapshot}" var="result">
    SELECT * FROM GIANGVIEN;
</sql:query>
<table border="1" width="100%">
    <tr>
        <th>Faculty ID</th>
        <th>Full Name</th>
        <th>Research Area</th>
        <th>Telephone Number</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
    <tr>
        <td><c:out value="${row.MAGV}"/></td>
        <td><c:out value="${row.HOTEN}"/>
            <u><i>Danh sách đề tài: </i></u>
            <sql:query dataSource="${snapshot}" var="detaigv">
                SELECT * FROM DETAI WHERE MAGV = ?;
                <sql:param value="${row.MAGV}"/>
            </sql:query>
            <ul>
                <c:forEach var="rowdt" items="${detaigv.rows}">
                    <li><c:out value="${rowdt.TENDT}"/></li>
                </c:forEach>
            </ul>
        </td>
        <td><c:out value="${row.LINHVUCGHIENCUU}"/></td>
        <td><c:out value="${row.SODIENTHOAI}"/></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>