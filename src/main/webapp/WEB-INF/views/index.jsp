<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 06.08.16
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/index.css"/>">
</head>
<body>
<h1>Notes</h1>
<div class="separator">
    <a class="link" href="<c:url value="/register"/>">Register/Login</a>
</div>
<h3>Welcome to the Notes!</h3>

Notes can help you to create notes.<br>
<a href="<c:url value="/register"/>">Register/Login</a> for to start work with this application.
<div class="separator bottom" ></div>
</body>
</html>