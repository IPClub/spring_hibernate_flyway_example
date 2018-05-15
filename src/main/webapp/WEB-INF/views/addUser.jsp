<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add user</title>
</head>
<body>
<h1>Add user page</h1>
<form method="post" action="/saveUser">

    <p>Username: </p><input type="text" name="username">
<br>
    <input type="submit" value="save">

</form>

</body>
</html>