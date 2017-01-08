<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 29.12.16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
</head>
<body>
<h1 style="color:red">Notes - Access Denied</h1>
<div class="separator top">
    <a class="link" href="<c:url value="/auth/register"/>">Register</a><span class="text"> | </span><a class="link" href="<c:url value="/auth/login"/>">Login</a>
</div>
<div>
    Access denied, I invite you to <a href="<c:url value="/auth/register"/>">Register</a> or <a href="<c:url value="/auth/login"/>">Login</a></a>.
</div>
<div class="separator bottom auto" ></div>
</body>
</html>
