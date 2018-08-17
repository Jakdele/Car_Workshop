<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Delete employee</title>
</head>
<body>
<div class="text-center">
    <h2>Are you certain, that you want to delete employee ${id}?</h2>
</div>
<div class="text-center">
    <form action="/deleteEmployee" method="post">
        <input class="btn btn-primary btn-block-short" type="submit" value="Yes" name="confirm" >
        <input class="btn btn-primary btn-block-short" type="submit" value="No" name="confirm">
        <input type="hidden" name="employee.id" value="${id}">
    </form>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>
