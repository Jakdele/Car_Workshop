<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Vehicles list</title>
</head>
<body>
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
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addVehicle">Add a new vehicle</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>