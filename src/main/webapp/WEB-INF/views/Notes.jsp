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
    <script type="text/javascript" src="<c:url value="/resources/js/logout.js"/>"></script>
</head>
<body>
<h1>Notes - Profile</h1>
<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<div class="separator top">
    <span class="text">Welcome, <a class="link" href="/NotesWeb/notes/${username}">${username}</a> | <a class="link" href="javascript:formSubmit()">Logout</a></span>
</div>
<div>
    <a href="<c:url value="/notes/${username}/add"/>">Add note</a> | <a href="<c:url value="/notes/${username}/view"/>">View notes</a>
</div>
<div class="separator bottom auto" ></div>
</body>
</html>
