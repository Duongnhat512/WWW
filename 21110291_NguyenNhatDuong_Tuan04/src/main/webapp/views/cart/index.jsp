<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/9/2024
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <c:set var="total" value="0"/>
    <table>
        <thead>
        <tr>
            <th>Action</th>
            <th>ID</th>
            <th>Name</th>
            <th>Image</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.cart}" var="item">
            <c:set var="total" value="${total + item.product.price * item.quantity}"/>
            <tr>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}"
                       onclick="return confirm('Are you sure?')">Remove</a>
                </td>
                <td>${item.product.id}</td>
                <td>${item.product.name}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/resources/images/${item.product.image}" width="120"/>
                </td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price * item.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
