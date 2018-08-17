<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Order details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/orders">Orders</a>
    </li>
    <li class="breadcrumb-item active">Order ${order.id}</li>
</ol>

<div class="text-center">
    <h1>Order ${order.id}</h1>
</div>

<table class="table-small table-bordered" width="70%" cellspacing="5" align="center">

    <tbody>
    <tr>
        <th scope="row">Order id</th>
        <td>${order.id}</td>
        </th>
        <th scope="row">Vehicle being repaired</th>
        <td>${order.getVehicle().getId()}, id: <a href="<c:url value="/vehicleDetails"/>?vehicle.id=${order.getVehicle().getId()}">${order.getVehicle().getId()}</a></td>
        </th>
    </tr>
    <tr>
        <th scope="row">Car accepted on</th>
        <td>${order.carAccepted}</td>
        </th>
        <th scope="row">Repair status</th>
        <td>${order.status}</td>
        </th>
    </tr>
    <tr>
        <th scope="row">Planned repair start</th>
        <td>${order.plannedStart}</td>
        </th>
        <th scope="row">Actual repair start</th>
        <td>${order.actualStart}</td>
        </th>
    </tr>
    <tr>
        <th scope="row">Total repair cost</th>
        <td>${order.repairCost}</td>
        </th>
        <th scope="row">Parts cost</th>
        <td>${order.partsCost}</td>
        </th>
    </tr>
    <tr>
        <th scope="row">Assigned to </th>
        <td>${order.getEmployee().getSurname()}, id: <a href="<c:url value="/employeeDetails"/>?employee.id=${order.getEmployee().getId()}">${order.getEmployee().getId()}</a></td>
        </th>
        <th scope="row">Hourly wage</th>
        <td>${order.wage}</td>
        </th>
    </tr>
    <tr>
        <th scope="row">Problem description</th>
        <td>${order.problemDesc}</td>
        </th>
        <th scope="row">Repair details</th>
        <td>${order.repairDesc}</td>
        </th>
    </tr>
    <tr>
        <th scope="row">Manhours required</th>
        <td>${order.manhours}</td>
        </th>
    </tr>
    </tbody>
</table>

<hr>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/deleteOrder"/>?order.id=${order.id}">Delete
        order</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editOrder"/>?order.id=${order.id}">Edit order</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>