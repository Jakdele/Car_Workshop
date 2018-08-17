<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>New vehicle form</title>


</head>
<body>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/vehicles">Vehicles</a>
    </li>
    <li class="breadcrumb-item active">New vehicle</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Add a new vehicle</h1>
    </div>
    <form method="post" action="/addVehicle">
        <div class="form-group">
            <label for="make">Make</label>
            <input type="text" class="form-control" id="make" name="make" placeholder="Make">
            <label for="model">Model</label>
            <input type="text" class="form-control" id="model" name="model" placeholder="Model">
            <label for="manufactured">Production year</label>
            <input type="number" class="form-control" id="manufactured" name="manufactured"
                   placeholder="Production year">
            <label for="regNumber">Registration number</label>
            <input type="text" class="form-control" id="regNumber" name="regNumber" placeholder="Registration number">
            <label for="review">Next review date</label>
            <input type="date" class="form-control" id="review" name="nextReview" placeholder="YYYY-MM-DD">
            <label for="customer-id">Owner Id</label>
            <select id="customer-id" name="customer-id">
                <c:forEach items="${customers}" var="customer">
                    <option value="${customer.id}">${customer.surname}, id ${customer.id}</option>
                </c:forEach>
            </select>
            </div>

        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Add" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
        </div>
    </form>
</div>

</body>
</html>
<%@include file="default/footer.jsp" %>