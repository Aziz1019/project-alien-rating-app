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
    <title>Review Lists</title>
</head>
<body>
<h1>Reviews</h1>
<table border="1" width="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>User ID</th>
        <th>Review</th>
        <th>Alien ID</th>
        <th>Rating</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reviews}" var="r">
        <tr>
            <td>${r.getId()}</td>
            <td>${r.getUserId()}</td>
            <td>${r.getReview()}</td>
            <td>${r.getAlienId()}</td>
            <td>${r.getRating()}</td>
            <td>${r.getCreatedAt()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<br>
<a href="controller?command=forward_user&main=main_user">Main Page</a>
</body>
</html>