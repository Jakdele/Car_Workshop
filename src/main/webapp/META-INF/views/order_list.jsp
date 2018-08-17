<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Orders list</title>
</head>
<body>
 <div class="text-center">
    <h2>All orders</h2>
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
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><a href="<c:url value="/orderDetails"/>?order.id=${order.id}"> Details </a></td>
                <td> ${order.carAccepted} </td>
                <td> ${order.getEmployee().getSurname()}, id: <a href="<c:url value="/employeeDetails"/>?employee.id=${order.getEmployee().getId()}">${order.getEmployee().getId()}</a> </td>
                <td> ${order.getVehicle().getMake()} ${order.getVehicle().getModel()} </td>
                <td> ${order.repairCost} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addOrder">Add a new order</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>