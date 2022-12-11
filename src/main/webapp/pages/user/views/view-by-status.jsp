<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/26/2022
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Users</title>
</head>
<body>

<h1>Users Board</h1>

<table border="1" width="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.getId()}</td>
            <td>${u.getUsername()}</td>
            <td>${u.getStatus()}</td>
         </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<a href="controller?command=forward_register">Add New User</a>
<br>
<br>
<br>
<a href="controller?command=forward_user&main=main_user">Main Page</a>
</body>
</html>