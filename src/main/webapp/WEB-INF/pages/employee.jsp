<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<div style="width:100%; height: 60px ;background-color:#ABEBC6 ">
    <div style="width: 40px; height: 100%; border: solid 2px #ddd" >
        <a href="/" style="width: 100% ;height: 100%" >
            Home page
        </a>

    </div>
</div>
<div style="width:200px; height: 300px;float: left ;border: solid 2px #ddd">
    <c:if test="${employee.imgPath != null}">
       <img src="${employee.imgPath}" alt ="Employee picture" width="100%" height="100%">
    </c:if>
</div>
</body>
</html>
