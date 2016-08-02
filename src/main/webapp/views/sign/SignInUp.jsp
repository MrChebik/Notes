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
    <link rel="stylesheet" type="text/css" href="/css/views/sign/SignInUp.css" media="all">
    <script type="text/javascript" src="/js/views/sign/SignInUp.js"></script>
</head>
<body>
<div>
    <form id="form1" action="/notes/sign" method="post">
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
