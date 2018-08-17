<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Programming School</title>
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../vendor/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="../../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="../../css/sb-admin.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">
</head>
<h1>Car Workshop Manager</h1>
<c:if test="${not empty current}">
    <div class="text-center">
        <h2>Pending orders</h2>
    </div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Accepted</th>
            <th>Employee assigned</th>
            <th>Vehicle</th>
            <th>Cost</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${current}">
            <tr>
                <td><a href="<c:url value="/customerDetails"/>?order.id=${order.id}"> Details </a></td>
                <td> ${order.carAccepted} </td>
                <td> ${order.getEmployee().getSurname()}, id: ${order.getEmployee().getId()} </td>
                <td> ${order.getVehicle().getMake()} ${order.getVehicle().getModel()} </td>
                <td> ${order.repairCost} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>

<%@include file="default/footer.jsp" %>