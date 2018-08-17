<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Employee edit form</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/employees">Employees</a>
    </li>
    <li class="breadcrumb-item active">Employee ${id}</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Employee ${id}</h1>
    </div>
    <form method="post" action="/editEmployee">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
            <label for="surname">Surname</label>
            <input type="text" class="form-control" id="surname" name="surname" placeholder="Surname">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="Address">
            <label for="note">Note</label>
            <input type="text" class="form-control" id="note" name="note" placeholder="Note">
            <label for="wage">Hourly wage</label>
            <input type="text" class="form-control" id="wage" name="wage" placeholder="Use '.'  e.g. 12.50">

        </div>

        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Edit" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
            <input type="hidden" name="employee-id" value="${id}">
        </div>
    </form>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>