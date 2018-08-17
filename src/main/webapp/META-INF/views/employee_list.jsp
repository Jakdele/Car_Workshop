<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Employees list</title>
</head>
<body>
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
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><a href="<c:url value="/employeeDetails"/>?employee.id=${employee.id}"> ${employee.id} </a></td>
                <td> ${employee.name} </td>
                <td> ${employee.surname} </td>
                <td> ${employee.phone} </td>
                <td> ${employee.address} </td>
                <td> ${employee.note}</td>
                <td> ${employee.wage}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addEmployee">Add a new employee</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>