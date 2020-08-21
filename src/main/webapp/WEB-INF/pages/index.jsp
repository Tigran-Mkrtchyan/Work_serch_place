
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Welcome Staff</title>
    <style ><%@include file="/WEB-INF/css/indexStyle.css"%></style>
</head>
<body style="width: 1000px ;margin: 0 auto">
<div style="width: 100%; height: 70px ;background-color: #ABEBC6 ; position: relative ">
    <form>
        <label>
            <input class ="myButton" style="float: left;margin-left: 20px; margin-top: 20px;" type="submit"
                   value="Search"/>
        </label>
        <label>
            <input style="float: left; width: 500px; margin-left: 40px; margin-top: 20px; height: 30px;" type="text" placeholder="Search"/>
        </label>
    </form>

    <c:if test="${logged == null}" >
    <form action="${pageContext.request.contextPath}/register?company=x" method="get" target="iframe_a">
        <label style="position: absolute ;left: 920px;color: whitesmoke"  >
            Company: <input style="position: absolute;left: 25px; top: 35px"  name= "company" type="checkbox" />
        </label>
        <label >
            <input class="myButton" style="position: absolute ;left: 850px ;top: 35px;"  type="submit" value="Sign Up">
        </label>
    </form>
<form action="${pageContext.request.contextPath}/login" method="post" >
    <label >
        <input class="myButton" style="position: absolute ;top: 1px; left: 850px ;" type="submit" value="Sign In" >
    </label>
      <label >
           <input style="position: absolute ;left: 640px ;top: 2px; height: 30px" name= "email" type="text" placeholder="Email:" />
      </label>
      <label >
            <input style="position: absolute ; left: 640px ;top: 35px; height: 30px" name= "pass" type="password" placeholder="Password"/>
      </label>
 </form>

    <c:if  test="${param['error'] != null}">
        <h6 style="position: absolute ;top:-15px;left: 805px; color:red" >Invalid <br>Email or<br>Password</h6>
    </c:if>

</c:if>
    <c:if test="${logged != null}" >
        <h4 style="position: absolute ;left: 700px " >welcome ${logged.name}</h4>
        <a href="${pageContext.request.contextPath}/logout" >
           <button class="myButton" style="position: absolute ;left: 900px ; top :15px" >Logout</button>
        </a>
        <a href="${pageContext.request.contextPath}/userPage" >
           <button class="myButton" style="position: absolute ;left: 830px ; top :15px" >View Profile</button>
        </a>
</c:if>
</div>
<div style="width: 25%; height:100%;float: left; background-color: #ABEBC6 ">
    <form action="${pageContext.request.contextPath}/posts" target="iframe_a" method="post">
    <h2>Filter by skills</h2>
    <label>
        <select class="filterSelect" name="skill" >
            <option >All</option>
            <c:forEach var="item" items="${skills}">
               <option >${item}</option>
            </c:forEach>
        </select>
    </label>
    <h2>Filter by job types </h2>
    <label>
        <select class="filterSelect" name="jobType" >
            <option >All</option>
            <c:forEach var="item" items="${jobTypes}">
                <option >${item}</option>
            </c:forEach>
        </select>
    </label>
    <h2> Filter by companies</h2>
    <label>
        <select class="filterSelect" name="company" >
            <option >All</option>
            <c:forEach var="item" items="${companies}">
                <option >${item}</option>
            </c:forEach>
        </select>
    </label>
    <h2> Filter by specialist level</h2>
    <label>
        <select class="filterSelect" name="level" >
            <option >All</option>
            <c:forEach var="item" items="${levels}">
                <option >${item}</option>
            </c:forEach>
        </select>
    </label>
        <label>
            <input class="myButton" type="submit" value="Filter" style="margin: 10px 100px;" >
        </label>
    </form>
</div>
<div style="width:75%;float: left;height: 100%;">
    <iframe src="${pageContext.request.contextPath}/posts" name="iframe_a" height="100%" width="100%" frameborder="0" ></iframe>

</div>

</body>
</html>
