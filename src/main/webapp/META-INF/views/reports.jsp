<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Financial reports</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/home">Homepage</a>
    </li>
    <li class="breadcrumb-item active">Reports</li>
</ol>

<div>
    <form method="post" action="/reports">
    <div class="form-group">
        <label for="start">Select start date</label>
        <input type="text" class="form-control" id="start" name="start" placeholder="1970-01-01 00:00">
        <label for="stop">Select end date</label>
        <input type="text" class="form-control" id="stop" name="stop" placeholder="1970-01-01 00:00">
        <div class="text-center">
            <input type="radio" class="radio" name="report" value="1" checked id="manhours" >
            <label for="manhours">Manhours</label>
            <input type="radio" class="radio" name="report" value="2" id="profit">
            <label for="profit">Profit</label>
        </div>
        <input type="submit" value="Submit">
    </div>
    </form>
</div>
<c:if test="${not empty manhours}">
    <hr>
    <div>
        <table class="table table-bordered" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th>Employee id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Total manhours</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="manhour" items="${manhours}">
                <tr>
                    <td><a href="<c:url value="/employeeDetails"/>?employee.id=${manhour.key.id}"> Details </a></td>
                    <td> ${manhour.key.name} </td>
                    <td> ${manhour.key.surname} </td>
                    <td> ${manhour.value} </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<c:if test="${not empty total}">
    <hr>
    <div class="text-center">
        <h3>Total profits for the selected period ${total}</h3>
    </div>
</c:if>

</body>
</html>
<%@include file="default/footer.jsp" %>