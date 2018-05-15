<%@ page import="java.util.List" %>
<%@ page import="com.tasks.TaskManager.model.User" %>
<%@ page import="com.tasks.TaskManager.model.Task" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


    <title>Task Manager</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script>
        $(document).ready(function () {
            $("select").change(function () {
                $("#main").empty();
                $.ajax({
                    url: "/api/user/" + this.value,
                    success: function (result) {
                        var tasks = result.tasks;
                        if (tasks.length > 0) {
                            var code = "<table  border=\"1\" cellpadding=\"10\">\n" +
                                "    <tr>\n" +
                                "        <th>Id</th>\n" +
                                "        <th>Title</th>\n" +
                                "        <th>Description</th>\n" +
                                "        <th>Created date</th>\n" +
                                "        <th>Severity</th>\n" +
                                "        <th>Status</th>\n" +
                                "        <th>Delete</th>\n" +
                                "    </tr>";
                            var i;
                            for (i = 0; i < tasks.length; i++) {
                                code += "<tr>";
                                code += "<td>" + tasks[i].id + "</td>";
                                code += "<td><a href=/editTask/" + tasks[i].id + ">" + tasks[i].title + "</a></td>";
                                code += "<td>" + tasks[i].description + "</td>";
                                code += "<td>" + tasks[i].createdAt + "</td>";
                                code += "<td>" + tasks[i].severity + "</td>";
                                code += "<td>" + tasks[i].status + "</td>";
                                code += "<td><a href=/deleteTask/" + tasks[i].id + ">" + "Yes</a></td>";
                                code += "</tr>";
                            }
                            code += "</table>";
                            $("#main").empty();
                            $("#main").append(code);
                        }

                    }
                });
            });
        });
    </script>
</head>
<body>
<h1>Home page</h1>

<h2>    Choose User  </h2>
<select>
    <option style="display:none;"></option>
    <c:forEach items="${users}" var="user">
        <option value="<c:out value="${user.id}"/>"><c:out value="${user.username}"/></option>
    </c:forEach>
</select>

<a href="/addUser">Add New User</a><br><br><br><br>

<a href="/addTask">Add Task</a><br><br>
<span id="main">

</span>


</body>
</html>