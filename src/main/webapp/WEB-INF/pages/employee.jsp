<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Employee</title>
    <style>
        body{
            width: 1000px ;
            margin: 0 auto;
        }
        .header {
            height: 60px;
            width: 100%;
            background-color: #abebc6;
        }
        .header a {
            height: 80%;
            width: 60px;
            padding: 6px;
            color: #000000;
            text-align: center;
            text-decoration: none;
            display: block;
        }
        .header button {
            height: 80%;
            width: 60px;
            padding: 6px;
            color: black;
            text-align: center;
            text-decoration: none;
            display: block;
        }
        .header a:hover {
            background-color: #dddddd;
            color: black;
        }
        .employeeInf{
            float: left;
            width: 792px;
            height: 100%;
            border: solid 2px #abebc6;
            background-color: whitesmoke;
        }
        .employeeInf h1 {
            margin: 10px 150px;
        }
        .employeeInf h3 {
            margin: 30px 100px;
        }
        .posts{
            float: left;
            width: 996px;
            height: 300px;
            border: 2px solid #abebc6;
            background-color: whitesmoke;
        }
        .subscribe{
            float: right;
            background-color: #abebc6;
        }
    </style>
</head>
<body>
<div class ="header">
    <div style="float: left" >
        <a href="${pageContext.request.contextPath}/" >
            Home page
        </a>
    </div>
    <div  style="float: right" >
        <a href="${pageContext.request.contextPath}/user/employee/edit">
            Edit page
        </a>
    </div>
    <div  class ="subscribe" style="float: right" >
        <form method="post" action="${pageContext.request.contextPath}/posts" target="iframe_e">
            <label>
                <select name="company" >
                    <option > --- </option>
                    <c:forEach var="item" items="${companies}">
                        <option >${item}</option>
                    </c:forEach>
                    <input type="submit" value="subscribe">
                </select>
            </label>
        </form>
    </div>
</div>
<div style="width: 100% ;height: 300px">
    <div style="width:200px; height: 300px;float: left ;border: solid 2px #dddddd">
        <c:if test="${employee.imgPath != null}">
           <img src="${employee.imgPath}" alt ="Employee picture" width="100%" height="100%">
        </c:if>
        <c:if test="${employee.imgPath == null}">
            <button style=" width:100% ;height:100%">Add photo</button>
        </c:if>
    </div>
    <div class="employeeInf">

            <h1>${employee.firstName} ${employee.lastName} </h1>
            <h3> Date of birth :${employee.birthday}</h3>
            <h3> Age : ${employee.age} </h3>
        <c:if test="${employee.phoneNumber != null}">
            <h3 >Phone number: ${employee.phoneNumber} </h3>
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
