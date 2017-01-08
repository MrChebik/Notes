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
    <script type="text/javascript" src="<c:url value="/resources/js/logout.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
</head>
<body>
<h1>Notes - Add note</h1>
<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<div class="separator top">
    <span class="text">Welcome, <a class="link" href="/NotesWeb/notes/${username}">${username}</a> | <a class="link" href="javascript:formSubmit()">Logout</a></span>
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
    <a class="link" href="<c:url value="/notes/"/>">Back</a>
</div>
</body>
</html>
