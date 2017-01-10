<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 03.01.17
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/SignInUp.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/SignInUp.js"/>"></script>
</head>
<body>
<h1>Notes - Registration</h1>
<div class="separator top">
    <a class="link" href="<c:url value="/auth/register"/>">Register</a><span class="text"> | </span><a class="link" href="<c:url value="/auth/login"/>">Login</a>
</div>
<div class="login-box">
    <form:form id="form1" modelAttribute="userForm" method="post">
        <c:if test="${error != null}">
            <p>
                Duplicate user.
            </p>
        </c:if>
        <table>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    <spring:bind path="username">
                        <input id="username" type="text" name="username" oninput="check('username')">
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <spring:bind path="password">
                        <input id="password" type="password" name="password" oninput="check('password')">
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>
                    Password Confirm:
                </td>
                <td>
                    <spring:bind path="passwordConfirm">
                        <input id="passwordConfirm" type="password" name="passwordConfirm" oninput="check('passwordConfirm')">
                    </spring:bind>
                </td>
            </tr>
        </table>
        <input type="button" value="Sign up" onclick="checkError()">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form:form>
</div>
<div class="separator bottom" >
    <a class="link" href="<c:url value="/"/>">Back</a>
</div>
</body>
</html>
