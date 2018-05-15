<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


    <title>Add task</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script>
        $(document).ready(function () {
            $("#user_combo").change(function () {
                $("#userId").val(this.value);
            });

            $("#severity_combo").change(function () {
                $("#severity").val(this.value);
            });

            $("#status_combo").change(function () {
                $("#status").val(this.value);
            });
        });
    </script>
</head>
<body>
<h1>Add task page</h1>
<form method="post" action="/saveTask">

    <input type="hidden" id="severity" name="severity" value="${task.severity.value}"/>
    <input type="hidden" id="status" name="status" value="${task.status.value}"/>
    <input type="hidden" name="id" value="${task.id}"/>

    <input type="hidden" id="userId" name="userId" value="${task.user.id}"/>
    <h3>title: </h3><input type="text" name="title" value="${task.title}"><br>
    <h3>description: </h3><input type="text" name="description" value="${task.description}"><br>
    <h3>severity: </h3>
    <select id="severity_combo">
        <option value="EASY" ${task.severity.value == 'EASY'?'selected':''}>EASY</option>
        <option value="MEDIUM" ${task.severity.value == 'MEDIUM'?'selected':''}>MEDIUM</option>
        <option value="HARD" ${task.severity.value == 'HARD'?'selected':''}>HARD</option>
    </select><br>
    <h3>status: </h3>
    <select id="status_combo">
        <option value="NOT_STARTED" ${task.status.value == 'NOT_STARTED'?'selected':''}>NOT_STARTED</option>
        <option value="IN_PROGRESS" ${task.status.value == 'IN_PROGRESS'?'selected':''}>IN_PROGRESS</option>
        <option value="ENDED" ${task.status.value == 'ENDED'?'selected':''}>ENDED</option>
    </select><br>
    <h3>Assign to user: </h3>
    <select id="user_combo">
        <c:forEach items="${users}" var="user">
            <option value="<c:out value="${user.id}"/>" ${task.user.id==user.id?'selected':''}><c:out value="${user.username}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="save">

    <h3>Comments: </h3>
    <a href="/addComment?task_id=${task.id}">Add New Comment</a><br>
    <table  border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Comment</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${task.comments}" var="comment">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.text}</td>
                <td><a href="/deleteComment/${task.id}/${comment.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</form>

</body>
</html>