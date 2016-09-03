<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 08.08.16
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
</head>
<body>
<h1>Notes - Profile</h1>
<div class="separator top">
    <span class="text">Welcome, <a class="link" href="/notes/${username}">${username}</a> | <a class="link" href="/notes/${username}/exit">Exit</a></span>
</div>
<div>
    <a href="<c:url value="/notes/${username}/add"/>">Add note</a> | <a href="<c:url value="/notes/${username}/view"/>">View notes</a>
</div>
<div class="separator bottom auto" ></div>
</body>
</html>
