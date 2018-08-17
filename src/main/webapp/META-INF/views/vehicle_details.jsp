<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Vehicle details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/vehicles">Vehicles</a>
    </li>
    <li class="breadcrumb-item active">Vehicle ${vehicle.id}</li>
</ol>

<hr>
<div class="text-center">
    <h2>Vehicle ${vehicle.id}</h2>
</div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Make</th>
            <th>Model</th>
            <th>Prod. year</th>
            <th>Reg. number</th>
            <th>Next review date</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td> ${vehicle.id} </a></td>
            <td> ${vehicle.make} </td>
            <td> ${vehicle.model} </td>
            <td> ${vehicle.manufactured} </td>
            <td> ${vehicle.regNumber} </td>
            <td> ${vehicle.nextReview} </td>
            <td>
                <a href="<c:url value="/customerDetails"/>?customer.id=${vehicle.owner.getId()}"> ${vehicle.owner.getId()} </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<c:if test="${not empty orders}">
    <hr>
    <div class="text-center">
        <h2>Vehicle ${vehicle.id} repairs</h2>
    </div>
    <div>
        <table class="table table-bordered" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th>Id</th>
                <th>Repair start date</th>
                <th>Repair description</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><a href="<c:url value="/orderDetails"/>?order.id=${order.id}"> ${order.id} </a></td>
                    <td> ${order.actualStart} </td>
                    <td> ${order.repairDesc} </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <hr>
</c:if>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/deleteVehicle"/>?vehicle.id=${vehicle.id}">Delete
        vehicle</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editVehicle"/>?vehicle.id=${vehicle.id}">Edit
        vehicle</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>