<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Customers list</title>
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
            <th>Birthday</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><a href="<c:url value="/customerDetails"/>?customer.id=${customer.id}"> ${customer.id} </a></td>
                <td> ${customer.name} </td>
                <td> ${customer.surname} </td>
                <td> ${customer.phone} </td>
                <td> ${customer.address} </td>
                <td> ${customer.birthday}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addCustomer">Add a new customer</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>