<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Order edit form</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/orders">Orders</a>
    </li>
    <li class="breadcrumb-item active">Order ${id}</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Order ${id}</h1>
    </div>
    <form method="post" action="/editOrder">
        <div class="form-group">
            <label for="carAccepted">Car accepted on</label>
            <input type="text" class="form-control" id="carAccepted" name="carAccepted"
                   placeholder="1970-01-01 00:00">
            <label for="plannedStart">Planned repair start</label>
            <input type="text" class="form-control" id="plannedStart" name="plannedStart"
                   placeholder="1970-01-01 00:00">
            <label for="actualStart">Actual repair start</label>
            <input type="text" class="form-control" id="actualStart" name="actualStart"
                   placeholder="1970-01-01 00:00">
            <label for="employee-id">Assigned to</label>
            <select id="employee-id" name="employee-id">
                <c:forEach items="${employees}" var="employee">
                    <option value="${employee.id}">${employee.surname}, id ${employee.id}</option>
                </c:forEach>
            </select>
            <br>
            <label for="problemDesc">Problem description</label>
            <input type="text" class="form-control" id="problemDesc" name="problemDesc"
                   placeholder="Problem description">
            <label for="repairDesc">Repair description</label>
            <input type="text" class="form-control" id="repairDesc" name="repairDesc" placeholder="Repair description">
            <label for="status">Status</label>
            <select id="status" name="status">
                    <option value="ACCEPTED">Accepted</option>
                    <option value="CONFIRMED">Confirmed</option>
                    <option value="IN_REPAIR">In repair</option>
                    <option value="READY">Ready</option>
                    <option value="CANCELLED">Cancelled</option>
            </select><br>
            <label for="vehicle-id">Vehicle</label>
            <select id="vehicle-id" name="vehicle-id">
                <c:forEach items="${vehicles}" var="vehicle">
                    <option value="${vehicle.id}">${vehicle.model}, ${vehicle.manufactured}, id ${vehicle.id}</option>
                </c:forEach>
            </select><br>
            <label for="repairCost">Total repair cost</label>
            <input type="text" class="form-control" id="repairCost" name="repairCost" placeholder="Total repair cost">
            <label for="partsCost">Parts cost</label>
            <input type="text" class="form-control" id="partsCost" name="partsCost" placeholder="Parts cost">
            <label for="manhours">Manhours required</label>
            <input type="text" class="form-control" id="manhours" name="manhours" placeholder="Manhours required">

        </div>

        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Edit" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
            <input type="hidden" name="order-id" value="${id}">
        </div>
    </form>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>