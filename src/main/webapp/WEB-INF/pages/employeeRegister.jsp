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
<div style="width: 500px; border: 2px solid ; margin: 100px auto ">
    <form action="${pageContext.request.contextPath}/register" method="post" >
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
            <tr>
            <td> Birthday:</td>
            <td>YY :<input name="y" type="number" min=1900 max=2020 width="25%"/>
                MM : <input name="m" type="number" min=1 max=12 width="25%"/>
                 DD : <input name="d" type="number"  min=1 max=31 width="25%"/>
            </td>
            </tr>

        </table>
        <input type="submit" value="Sign Up" style="width: 30% ;margin: 10px 150px"/>
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
