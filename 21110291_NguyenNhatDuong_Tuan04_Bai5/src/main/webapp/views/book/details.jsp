<%@ page import="com.bean.Book" %>
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
            <div class="row">
                <div class="col-md-4 mb-4 d-flex align-items-stretch" >
                    <div class="card align-items-center">
                        <% Book book = (Book) request.getAttribute("book");
                        <h5 class="card-title" style="text-align: center">${book.name} - Tác giả: ${book.author}</h5>
                        <img src="${pageContext.request.contextPath}/resources/images/${book.image}" width="120px" alt="${book.name}">
                        <div class="card-body">
                            <p class="card-text">Price: ${book.price}</p>
                            <p class="card-text">Quantity: ${book.quantity}</p>
                            <a href="${pageContext.request.contextPath}/book" class="btn btn-primary">Back to Product list</a>
                        </div>
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>