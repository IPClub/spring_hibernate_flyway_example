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

    <input type="hidden" id="severity" name="severity" value="EASY"/>
    <input type="hidden" id="status" name="status" value="NOT_STARTED"/>

    <input type="hidden" id="userId" name="userId" value="1"/>
    <p>title: </p><input type="text" name="title"><br>
    <p>description: </p><input type="text" name="description"><br>
    <p>severity: </p>
    <select id="severity_combo">
        <option value="EASY">EASY</option>
        <option value="MEDIUM">MEDIUM</option>
        <option value="HARD">HARD</option>
    </select><br>
    <p>status: </p>
    <select id="status_combo">
        <option value="NOT_STARTED">NOT_STARTED</option>
        <option value="IN_PROGRESS">IN_PROGRESS</option>
        <option value="ENDED">ENDED</option>
    </select><br>

    <select id="user_combo">
        <c:forEach items="${users}" var="user">
            <option value="<c:out value="${user.id}"/>"><c:out value="${user.username}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="save">

</form>

</body>
</html>