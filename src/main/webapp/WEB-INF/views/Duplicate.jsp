<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 08.08.16
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes - Sign in</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
</head>
<body>
<h1>Notes</h1>
<div class="separator top">
    <a class="link" href="<c:url value="/register"/>">Register/Login</a>
</div>
The login is busy.<br>
<div class="separator bottom" >
    <a class="link" href="<c:url value="/register"/>">Back</a>
</div>
</body>
</html>
