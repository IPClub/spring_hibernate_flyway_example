<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add Comment</title>
</head>
<body>
<h1>Add user page</h1>
<form method="post" action="/saveComment">
    <input type="hidden" name="task_id" value="${task_id}"/>
    <p>Comment: </p><input type="text" name="text">
    <br>
    <input type="submit" value="save">

</form>

</body>
</html>