
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
    <style>
        input{
            width: 20%;

        }
    </style>
    <% String error = request.getParameter("error");%>
</head>
<body style="background-color: dimgray">
<div style="width: 500px; background-color: azure; margin: auto auto ">
    <form action="${pageContext.request.contextPath}/signUp" method="post" style="alignment: left">
        <table>
            <tr>
                <td>Email:</td>
                <td><input name= "email" type="text"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input name= "pass" type="password"/></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><input name= "firstName" type="text"/></td>
            </tr>

            <td>Last Name:</td>
            <td><input name= "lastName" type="text"/></td>
            </tr>
            <td> Birthday:</td>
            <td>YY :<input name="y" type="number" width="25%"/>
                MM : <input name="m" type="number" width="25%"/>
                 DD : <input name="d" type="number" width="25%"/>
            </td>
            "
            </tr>
            <tr>
                <td><input type="submit" value="SignUp"/></td>
            </tr>
        </table>
        <% if(error != null){
            if( request.getParameter("error").equals("email")){
                out.print("<h1>Email is invalid<h1>");
             }else if(request.getParameter("error").equals("pk")) {
                out.print("<h1>System Error try again please <h1>");
            }
        }
        %>
    </form>
</div>
</body>
</html>
