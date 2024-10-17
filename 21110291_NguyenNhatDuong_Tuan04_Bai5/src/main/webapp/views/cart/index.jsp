<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IUH Bookstore</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">IUH BOOKSTORE</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Examples</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Services</a></li>
                <li class="nav-item"><a class="nav-link" href="/book">Products</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main content -->
<div class="container mt-4">
    <div class="row">
        <!-- Left sidebar -->
        <div class="col-md-3">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">ABOUT US</h5>
                    <p>About us information will be here... <a href="#">Read More</a></p>
                </div>
            </div>
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">SEARCH SITE</h5>
                    <form>
                        <input type="text" class="form-control" placeholder="Search...">
                    </form>
                </div>
            </div>
        </div>

        <!-- Products -->
        <div class="col-md-9">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="0" scope="session" />
                <c:forEach items="${sessionScope.cart}" var="item">
                    <tr>
                        <td>${item.book.id}</td>
                        <td>${item.book.name}</td>
                        <td>${item.book.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.book.quantity * item.book.price}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cart?action=delete&id=${item.book.id}" class="btn btn-danger btn-sm"
                                onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
                        </td>
                    </tr>
                    <c:set var="total" value="${total + item.book.quantity * item.book.price}" scope="session" />
                </c:forEach>
                <tr>
                    <td colspan="4">Total</td>
                    <td>(VND) ${total}</td>
                    <td></td>
                </tr>
                </tbody>
            </table>

            <a href="${pageContext.request.contextPath}/payment?total=${total}" class="btn btn-primary">Checkout</a>
            <a href="${pageContext.request.contextPath}/book" class="btn" >Continue Shopping</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>