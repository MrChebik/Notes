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
    <title>Sign up</title>
    <link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/SignInUp.css"/>>
    <script type="text/javascript" src="<c:url value="/resources/js/SignInUp.js"/>"></script>
</head>
<body>
<div>
    <form id="form1" action="<c:url value="/register"/>" method="post">
        <table>
            <tr>
                <td>Login:</td>
                <td><input id="login" type="text" name="login" oninput="check('login')"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input id="password" type="text" name="password" oninput="check('password')"></td>
            </tr>
        </table>
        <div class="inputs">
            <input id="007" type="hidden" name="hide">
            <input id="up" type="button" value="Sign up" onclick="checkError('up')">
            <input id="in" type="button" value="Sign in" onclick="checkError('in')">
        </div>
    </form>
</div>
</body>
</html>
