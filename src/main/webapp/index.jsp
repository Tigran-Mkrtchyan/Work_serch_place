
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Staff</title>
</head>
<body style="background-color: dimgray">
<div>
<form action="${pageContext.request.contextPath}/userPage" method="post" style="alignment: left">
    <label>
        <input type="submit" value="SignIn">
    </label>
    <label>
        Email: <input name= "email" type="text">
    </label>
    <label>
        Password: <input name= "pass" type="password">
    </label>
 </form>
    <form action="${pageContext.request.contextPath}/signUp" method="get" style="alignment: right">
         <label>
            <input name= "email" type="submit" value="SignUp">
        </label>

        <label>
            Company: <input name= "company" type="checkbox"/>
        </label>
    </form>
<%if(request.getParameter("error") != null ){
    out.print("<h3>Email or Password incorrect</h3>");
}%>
</div>
</body>
</html>
