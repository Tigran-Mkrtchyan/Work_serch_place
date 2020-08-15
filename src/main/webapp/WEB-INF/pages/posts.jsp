<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${skill != null}">
    <h1>Selected are</h1>
    <ul>
        <li>${skill}</li>
        <li>${level}</li>
        <li>${jobType}</li>
        <li>${company}</li>
    </ul>

</c:if>
<c:if test="${skill == null}">
<h1> Hello </h1>
</c:if>
</body>
</html>
