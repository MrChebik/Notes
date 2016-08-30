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
        <script type="text/javascript" src="<c:url value="/resources/js/AddNote.js"/>"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <h2>Add note</h2>
        <table>
            <tr>
                <td>Title:</td>
                <td><input id="titleId" type="text" name="title"></td>
            </tr>
            <tr>
                <td>Text:</td>
                <td><input id="textId" type="text" name="text"></td>
            </tr>
            <tr>
                <td>
                    <input type="button" onclick="sendNote()" value="Add">
                </td>
            </tr>
        </table>
        <a href="<c:url value="/notes/${username}"/>">Back</a>
    </body>
</html>
