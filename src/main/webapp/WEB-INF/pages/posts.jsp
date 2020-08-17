<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .postHeader{
            margin: 10px;
            width: 97%;
            height: 80px;

            border: 2px solid #ABEBC6;

        }
        .postHeader img{
            float: left;
            width: 80px;
            height: 80px;
            background-color: #dddddd;
            border-right: 1px solid #ABEBC6;
        }

        .postHeader div{
            float: left;
            margin-left: 20px;
            width: 250px;
            height: 80px;
        }
    </style>
</head>
<body >
<div>
    <c:forEach var="post" items="${postHeaders}">
        <a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/postHeaders/${post.postId}">
            <div class ="postHeader" style="margin: 10px;">
                <c:if test="${post.logoPath != null}">
                    <img alt="logo" src="${post.logoPath}"/>
                </c:if>
                <c:if test="${post.logoPath == null}">
                    <p style="width:80px;float: left">
                            ${post.companyName}</p>
                </c:if>
                <div style="float:left; ">
                    <p>
                    <c:forEach var="level" items="${post.levels}">
                       ${level}
                    </c:forEach>
                        -  ${post.skill} Developer
                    </p>

                    <p>Company: ${post.companyName}</p>

                </div>
                <div style="float:left; ">
                    <p>Job type: ${post.jobType}</p>
                    <p>Deadline: ${post.deadline}</p>
                </div>
            </div>
        </a>
    </c:forEach>

</div>
</body>
</html>
