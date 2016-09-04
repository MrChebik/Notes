<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 21.07.16
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register/Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/SignInUp.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/SignInUp.js"/>"></script>
</head>
<body>
<h1>Notes</h1>
<div class="separator top">
    <a class="link" href="<c:url value="/register"/>">Register/Login</a>
</div>
<div>
    <form id="form1" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input id="username" type="text" name="username" oninput="check('username')"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input id="password" type="password" name="password" oninput="check('password')"></td>
            </tr>
        </table>
        <input id="007" type="hidden" name="hide">
        <input id="up" type="button" value="Sign up" onclick="checkError('up')">
        <input id="in" type="button" value="Sign in" onclick="checkError('in')">
    </form>
</div>
<div class="separator bottom" >
    <a class="link" href="<c:url value="/"/>">Back</a>
</div>
</body>
</html>
