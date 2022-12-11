<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/27/2022
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>View Blocked Users</title>
</head>
<body>

<h1>Banned Users</h1>


<table border="1" width="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Status</th>
        <th>Password</th>
        <th>Active</th>
        <th>Role</th>
        <th>Date</th>
        <th>Edit</th>
        <th>Delete</th>
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
                <a href="controller?command=delete&id=${u.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<br>
<a href="controller?command=forward_user&main=main_admin">Main Page</a>
</body>
</html>