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
    <title>View Aliens</title>
</head>
<body>

<%
    request.setAttribute("id", session.getAttribute("id"));
%>

<h1>Aliens</h1>
<table border="1" width="1">
    <thead>
    <tr>
        <th>Alien Name</th>
        <th>Source</th>
        <th>Date</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${aliens}" var="a">
        <tr>
            <td>${a.getAlienName()}</td>
            <td>${a.getSource()}</td>
            <td>${a.getCreatedAt()}</td>
            <td><a href="controller?command=forward_review&page=add_review&alien_id=${a.getId()}&user_id=${id}">
                <img src="${a.getImageUrl()}" width="50" alt="Image of an alien">
            </a></td>
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