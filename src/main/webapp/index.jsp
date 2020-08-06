
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome Staff</title>
</head>
<body style="background-color: dimgray">
<div style="width: 500px;background-color: Menu; border: 2px solid ; margin: 10px 900px ">
<form action="${pageContext.request.contextPath}/userPage" method="post" style="alignment: left">
    <table>
        <tr>
            <td>Email:</td>
            <td><label>
                <input name= "email" type="text"/>
            </label></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><label>
                <input name= "pass" type="password"/>
            </label></td>
        </tr>
    </table>
    <label>
        <input type="submit" value="Sign In" >
    </label>
 </form>
    <form action="${pageContext.request.contextPath}/signUp" method="get" style="alignment: right">
         <label>
            <input name= "email" type="submit" value="Sign Up">
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
