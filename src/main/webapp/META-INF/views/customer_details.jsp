<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Customer details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/customers">Customers</a>
    </li>
    <li class="breadcrumb-item active">Customer ${customer.id}</li>
</ol>

<div class="text-center">
    <h1>Customer ${customer.id}</h1>
</div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Birthday</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td>${customer.id}</td>
            <td>${customer.name} </td>
            <td>${customer.surname} </td>
            <td>${customer.phone} </td>
            <td>${customer.address} </td>
            <td>${customer.birthday}</td>
        </tr>

        </tbody>
    </table>
</div>

<hr>
<c:if test="${not empty vehicles}">
    <div class="text-center">
        <h2>Customer ${customer.id} vehicles</h2>
    </div>
    <div>
        <table class="table table-bordered" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th>Id</th>
                <th>Make</th>
                <th>Model</th>
                <th>Prod. year</th>
                <th>Registration number</th>
                <th>Next review date</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="vehicle" items="${vehicles}">
                <tr>
                    <td><a href="<c:url value="/vehicleDetails"/>?vehicle.id=${vehicle.id}"> ${vehicle.id} </a></td>
                    <td> ${vehicle.make} </td>
                    <td> ${vehicle.model} </td>
                    <td> ${vehicle.manufactured} </td>
                    <td> ${vehicle.regNumber} </td>
                    <td> ${vehicle.nextReview} </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <hr>
</c:if>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/deleteCustomer"/>?customer.id=${customer.id}">Delete customer</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editCustomer"/>?customer.id=${customer.id}">Edit customer</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>