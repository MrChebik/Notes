<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 19.07.16
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Your notes</title>
        <link rel="stylesheet" type="text/css" href="/css/file.css" media="all">
    </head>
    <body>
    <c:choose>
        <c:when test="${notes.size() == 0}" >
            <h3>You do not have any notes.</h3>
        </c:when>
        <c:otherwise>
            <h3>Your notes.</h3>
            <table border="1" style="border-collapse: collapse">
                <tr>
                    <th>Title</th>
                    <th>Text</th>
                </tr>
                <c:forEach items="${notes}" var="note" >
                    <tr>
                        <td>${note.title}</td>
                        <td>${note.text}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <a href="/notes/view">Back</a>
</body>
</html>
