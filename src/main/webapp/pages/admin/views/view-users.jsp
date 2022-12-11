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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1>Active Users</h1>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Username</th>
        <th scope="col">Status</th>
        <th scope="col">Password</th>
        <th scope="col">Active</th>
        <th scope="col">Role</th>
        <th scope="col">Date</th>
        <th scope="col">Edit</th>
        <th scope="col">Block</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.getId()}</td>
            <td>${u.getUsername()}</td>
            <td>${u.getStatus()}</td>
            <td>${u.getPassword()}</td>
            <td>${u.getIsActive()}</td>
            <td>${u.getRole()}</td>
            <td>${u.getCreatedAt()}</td>
            <td>
                <a href="controller?command=edit&id=${u.getId()}">Edit</a>
            </td>
            <td>
                <a href="controller?command=block&id=${u.getId()}">Block</a>
            </td>
            <td>
                <a href="controller?command=delete&id=${u.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--<table border="1" width="1">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Id</th>--%>
<%--        <th>Username</th>--%>
<%--        <th>Status</th>--%>
<%--        <th>Password</th>--%>
<%--        <th>Active</th>--%>
<%--        <th>Role</th>--%>
<%--        <th>Date</th>--%>
<%--        <th>Edit</th>--%>
<%--        <th>Block</th>--%>
<%--        <th>Delete</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${users}" var="u">--%>
<%--        <tr>--%>
<%--            <td>${u.getId()}</td>--%>
<%--            <td>${u.getUsername()}</td>--%>
<%--            <td>${u.getStatus()}</td>--%>
<%--            <td>${u.getPassword()}</td>--%>
<%--            <td>${u.getIsActive()}</td>--%>
<%--            <td>${u.getRole()}</td>--%>
<%--            <td>${u.getCreatedAt()}</td>--%>
<%--            <td>--%>
<%--                <a href="controller?command=edit&id=${u.getId()}">Edit</a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="controller?command=block&id=${u.getId()}">Block</a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="controller?command=delete&id=${u.getId()}">Delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<br/><a href="controller?command=forward_register">Add New User</a>
<br>
<br>
<br>
<a href="controller?command=forward_user&main=main_admin">Main Page</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>