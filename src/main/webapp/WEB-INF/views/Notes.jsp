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
</head>
<body>
<h1>Hi, ${username}</h1>
<a href="<c:url value="/notes/${username}/add"/>">Add note</a> |
<a href="<c:url value="/notes/${username}/view"/>">View notes</a>
</body>
</html>
