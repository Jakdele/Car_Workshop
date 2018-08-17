<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Employee details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/employees">Employees</a>
    </li>
    <li class="breadcrumb-item active">Employee ${employee.id}</li>
</ol>

<div class="text-center">
    <h1>Employee ${employee.id}</h1>
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
            <th>Note</th>
            <th>Hourly wage</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td> ${employee.id} </a></td>
            <td> ${employee.name} </td>
            <td> ${employee.surname} </td>
            <td> ${employee.phone} </td>
            <td> ${employee.address} </td>
            <td> ${employee.note}</td>
            <td> ${employee.wage}</td>
        </tr>

        </tbody>
    </table>
</div>

<hr>
<c:if test="${not empty assigned}">
    <div class="text-center">
        <h2>Employee ${employee.id} is working on:</h2>
    </div>
    <div>
        <table class="table table-bordered" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th>Id</th>
                <th>Repair started</th>
                <th>Employee assigned</th>
                <th>Vehicle</th>
                <th>Total repair cost</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${assigned}">
                <tr>
                    <td><a href="<c:url value="/customerDetails"/>?order.id=${order.id}"> Details </a></td>
                    <td> ${order.actualStart} </td>
                    <td> ${order.getEmployee().getSurname()}, id: ${order.getEmployee().getId()} </td>
                    <td> ${order.getVehicle().getMake()} ${order.getVehicle().getModel()} </td>
                    <td> ${order.repairCost} </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <hr>
</c:if>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/deleteEmployee"/>?employee.id=${employee.id}">Delete employee</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editEmployee"/>?employee.id=${employee.id}">Edit employee</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>