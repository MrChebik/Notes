<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 19.07.16
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add note</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/AddNote.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
<h1>Notes - Add note</h1>
<div class="separator top">
    <span class="text">Welcome, <a class="link" href="/notes/${username}">${username}</a> | <a class="link" href="/notes/${username}/exit">Exit</a></span>
</div>
<div>
    <table>
        <tr>
            <td>Title:</td>
            <td><input id="titleId" type="text" name="title"></td>
        </tr>
        <tr>
            <td>Text:</td>
            <td><input id="textId" type="text" name="text"></td>
        </tr>
    </table>
    <input type="button" onclick="sendNote()" value="Add">
</div>
<div class="separator bottom">
    <a class="link" href="<c:url value="/notes/${username}"/>">Back</a>
</div>
</body>
</html>
