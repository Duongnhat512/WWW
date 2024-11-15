<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 13/11/2024
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List customer</title>
    <link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resource/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <input type="button" value="Add Customer"
                onclick="window.location.href='showFormForAdd'; return false;"
                class="add-button"/>
            <table>
                <tr>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Email</td>
                    <td>Actions</td>
                </tr>
                <c:forEach var="tmp" items="${customers}">
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tmp.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tmp.id}"/>
                    </c:url>
                    <tr>
                        <td>${tmp.firstName}</td>
                        <td>${tmp.lastName}</td>
                        <td>${tmp.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a> |
                            <a href="${deleteLink}"
                                onclick="if (!(confirm('Are you sure you want to delete thus customer?'))) return false">Delete</a>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
