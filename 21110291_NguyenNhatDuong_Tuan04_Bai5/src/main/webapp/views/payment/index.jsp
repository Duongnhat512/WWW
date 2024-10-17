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
            <h2>Checkout - Already registered?</h2>
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>Fullname</td>
                    <td><input type="text" name="name" class="form-control"></td>
                </tr>
                <tr>
                    <td>Shipping address</td>
                    <td><input type="text" name="address" class="form-control"></td>
                </tr>
                <tr>
                    <td>Total price</td>
                    <td><input type="text" name="total" class="form-control" value="${total}" readonly></td>
                </tr>
                <tr>
                    <td>Payment method</td>
                    <td><input type="radio" name="method" value="Paypal">Paypal<input type="radio" name="method" value="ATM Debit">ATM Debit<input type="radio" name="method" value="Visa/Master card">Visa/Master card</td>
                </tr>
                <tr>
                    <td class="text-center" colspan="2">
                        <a href="#" class="btn btn-primary">Save</a>
                        <a href="#" class="btn">Cancel</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>