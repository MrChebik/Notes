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
    </head>
    <body>
        <h3>Add note.</h3>
        <table>
            <form action="/notes/note/add" method="post">
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>Text:</td>
                    <td><input type="text" name="text"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Add">
                    </td>
                </tr>
            </form>
        </table>
        <a href="/views/Notes.html">Back</a>
    </body>
</html>
