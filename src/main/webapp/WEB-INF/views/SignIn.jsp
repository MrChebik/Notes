<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 02.01.17
  Time: 23:08
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
<h1>Notes - Login</h1>
<div class="separator top">
    <a class="link" href="<c:url value="/auth/register"/>">Register</a><span class="text"> | </span><a class="link" href="<c:url value="/auth/login"/>">Login</a>
</div>
<div class="login-box">
    <form id="form1" action="<c:url value="/j_spring_security_check"/>" method="post">
        <c:if test="${param.error != null}">
            <p>
                Invalid username or password.
            </p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p>
                You have been logged out.
            </p>
        </c:if>
        <table>
            <tr>
                <td>
                    <label for="username">Username</label>
                    <input id="username" type="text" name="username" oninput="check('username')">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">Password:</label>
                    <input id="password" type="password" name="password" oninput="check('password')">
                </td>
            </tr>
        </table>
        <input type="button" value="Sign in" onclick="checkError()">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</div>
<div class="separator bottom" >
    <a class="link" href="<c:url value="/"/>">Back</a>
</div>
</body>
</html>
