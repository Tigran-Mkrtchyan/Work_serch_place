<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../CSS/indexStyle.css" >
    <style>
        input{
            border: none;
            height: 30px;
            margin-left: 15px;
        }
    </style>

</head>
<body style="background-color: dimgray">
<div style="width: 500px; margin: 100px auto ;background-color: whitesmoke">
    <h1 style="margin: 10px 100px"> Register your account</h1>
    <form action="${pageContext.request.contextPath}/register" method="post" >
        <table>
            <tr>
                <td>First name:</td>
                <td><input name= "firstName" type="text" placeholder="First name"/></td>
            </tr>
            <tr>
            <td>Last name:</td>
            <td><input name= "lastName" type="text" placeholder="Last name"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input name= "email" type="text" placeholder="Email"/>

                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input name= "pass" type="password" placeholder="Password"/></td>
            </tr>

            <tr>
                <td>Repeat password:</td>
                <td><input name= "pass" type="password" placeholder="Password"/></td>
            </tr>
            <tr>
            <td> Date of birth:</td>
            <td>
                <input name="d" type="number"  min=1 max=31 placeholder="Day"/>
                <input name="m" type="number" min=1 max=12 placeholder="Month"/>
                <input name="y" type="number" min=1900 max=2020 placeholder="Year"/>
            </td>
            </tr>

        </table>
        <input type="submit" value="Sign Up" style="width: 30% ;height: 30px; margin: 10px 150px;background-color: green"/>
        <c:if  test="${param['error'] .equals('email')}">
            <h3 style="margin-left: 150px;color: red">Email is invalid</h3>
        </c:if>
        <c:if  test="${param['error'].equals('pk')}">
        <h3 style="margin-left: 150px;color: red">System Error try again please </h3>
        </c:if>

    </form>
</div>
</body>
</html>
