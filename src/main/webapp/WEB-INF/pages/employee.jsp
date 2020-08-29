<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
    <style>
        <%@include file="/WEB-INF/css/employeePageStyle.css" %>
    </style>
</head>
<body>
<div class="header">
    <div style="float: left">
        <a href="${pageContext.request.contextPath}/">
            Home page
        </a>
    </div>
    <div style="float: right">
        <a href="${pageContext.request.contextPath}/user/employee/edit">
            Edit page
        </a>
    </div>
</div>
<div style="width: 100% ;height: 300px">
    <div style="width:200px; height: 300px;float: left ;border: solid 2px #dddddd">
        <c:if test="${employee.imgUrl != null}">
            <img src="${employee.imgUrl}" alt="Employee picture" width="100%" height="100%">
        </c:if>
        <c:if test="${employee.imgUrl == null}">
            <button style=" width:100% ;height:100%">Add photo</button>
        </c:if>
    </div>
    <div class="employeeInf">
        <h1>${employee.firstName} ${employee.lastName} </h1>
        <h3> Date of birth :${employee.birthday}</h3>
        <h3> Age : ${employee.age} </h3>
        <c:if test="${employee.phoneNumber != null}">
            <h3>Phone number: ${employee.phoneNumber} </h3>
        </c:if>
        <c:if test="${employee.address != null}">
            <h3>Address : ${employee.address} </h3>
        </c:if>
    </div>
    <div class="posts">
        <iframe name="iframe_e" height="100%" width="100% " style="border: none"></iframe>
    </div>

</div>
</body>
</html>
