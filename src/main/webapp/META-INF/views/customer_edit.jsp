<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Client edit form</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/customers">Customers</a>
    </li>
    <li class="breadcrumb-item active">Customer ${id}</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Customer ${id}</h1>
    </div>
    <form method="post" action="/editCustomer">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
            <label for="surname">Surname</label>
            <input type="text" class="form-control" id="surname" name="surname" placeholder="Surname">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="Address">
            <label for="birthday">Birthday</label>
            <input type="date" class="form-control" id="birthday" name="birthday" placeholder="YYYY-MM-DD">
        </div>

        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Edit" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
            <input type="hidden" name="customer-id" value="${id}">
        </div>
    </form>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>