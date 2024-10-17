<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 19/9/2024
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product</title>
</head>
<body>
<table>

    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>
                <img src="${pageContext.request.contextPath}/resources/images/${product.image}" alt="${product.name}"
                     width="120px">
            </td>
            <td>${product.price}</td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}">Buy</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
