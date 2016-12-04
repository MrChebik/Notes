<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: mrchebik
  Date: 19.07.16
  Time: 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your notes</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ViewNotes.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/ViewNotes.js"/>"></script>
</head>
<body>
<h1>Notes - View notes</h1>
<div class="separator top">
    <span class="text">Welcome, <a class="link" href="/NotesWeb/notes/${username}">${username}</a> | <a class="link" href="/NotesWeb/notes/${username}/exit">Logout</a></span>
</div>
<div>
    <c:choose>
        <c:when test="${notes.size() == 0}" >
            <b>You do not have any notes</b>
        </c:when>
        <c:otherwise>
            <form id="form1" method="get">
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Text</th>
                    </tr>
                    <c:forEach items="${notes}" var="note" >
                        <tr>
                            <td>${note.title}</td>
                            <td>${note.text}</td>
                            <td><span class="fake-link" id="${note.id}" onclick="submitData(this.id, '0071')">Remove</span></td>
                        </tr>
                    </c:forEach>
                </table>
                <input id="0071" type="hidden" name="hideId">
                <c:choose>
                    <c:when test="${pages > 1}">
                        <br>
                        <input id="007" type="hidden" name="hide" value="${page}">
                        <c:choose>
                            <c:when test="${page > 4}">
                                <span class="fake-link" id="${1}" onclick="submitData(this.id, '007')">${1}</span> ...
                            </c:when>
                        </c:choose>
                        <c:forEach begin="${page > 4 ? page - 2 : 1}" end="${page + 4 > pages ? pages : page + 2}" var="pageId">
                            <c:choose>
                                <c:when test="${page == pageId}">
                                    <span class="fake-link currentPage" id="${pageId}" onclick="submitData(this.id, '007')">${pageId}</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="fake-link" id="${pageId}" onclick="submitData(this.id, '007')">${pageId}</span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${page + 4 <= pages}">
                                ... <span class="fake-link" id="${pages}" onclick="submitData(this.id, '007')">${pages}</span>
                            </c:when>
                        </c:choose>
                    </c:when>
                </c:choose>
            </form>
        </c:otherwise>
    </c:choose>
</div>
<div class="separator bottom" >
    <a class="link" href="<c:url value="/notes/${username}"/>">Back</a>
</div>
</body>
</html>