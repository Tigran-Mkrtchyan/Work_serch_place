
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Welcome Staff</title>
</head>
<body style="width: 1000px ;margin: 0 auto;background-color: dimgray">
<div style="width: 100%; height: 60px ;background-color: Menu; position: relative ">
    <form>
        <label>
            <input style="float: left; width: 60px; margin-left: 20px; margin-top: 15px; height: 30px;" type="submit"
                   value="Search"/>
        </label>
        <label>
            <input style="float: left; width: 500px; margin-left: 40px; margin-top: 15px; height: 30px;" type="text" placeholder="Search"/>
        </label>
    </form>

    <c:if test="${logged == null}" >
    <form action="${pageContext.request.contextPath}/register" method="get">
        <label style="position: absolute ;left: 920px"  >
            Company: <input style="position: absolute;left: 25px; top: 30px"  name= "company" type="checkbox" />
        </label>
        <label >
            <input style="position: absolute ;left: 850px ;top: 30px; height: 25px; width: 60px"  type="submit" value="Sign Up">
        </label>
    </form>
<form action="${pageContext.request.contextPath}/login" method="post" >
    <label >
        <input  style="position: absolute ;left: 850px ;height: 25px;width: 60px" type="submit" value="Sign In" >
    </label>
      <label >
           <input style="position: absolute ;left: 640px ; height: 25px" name= "email" type="text" placeholder="Email:" />
      </label>
      <label >
            <input style="position: absolute ; left: 640px ;top: 30px; height: 25px" name= "pass" type="password" placeholder="Password"/>
      </label>
 </form>

    <c:if  test="${param['error'] != null}">
        <h6 style="position: absolute ;top:-15px;left: 805px; color:red" >Invalid <br>Email or<br>Password</h6>
    </c:if>

</c:if>
    <c:if test="${logged != null}" >
        <h4 style="position: absolute ;left: 700px">welcome ${logged.name}</h4>
        <a href="${pageContext.request.contextPath}/logout" >
           <button style="position: absolute ;left: 900px ; top :15px;height: 33px;width: 60px" >Logout</button>
        </a>
        <a href="${pageContext.request.contextPath}/userPage" >
           <button style="position: absolute ;left: 830px ; top :15px;height: 33px;width: 60px" >View Profile</button>
        </a>
</c:if>
</div>
</body>
</html>
