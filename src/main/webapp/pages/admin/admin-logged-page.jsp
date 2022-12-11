<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/27/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>

<h1>Admin Page</h1>

<%= "Welcome " + session.getAttribute("user_name") %>

<br>
<br>
<br>
<%
    session.setAttribute("id", session.getAttribute("id"));
%>
<a href="controller?command=view_alien&page=admin">Aliens</a>
<br>
<br>
<br>
<a href="controller?command=view&block=0">Show users</a>
<br>
<br>
<br>
<a href="controller?command=forward_review&page=admin">Show Reviews</a>
<br>
<br>
<br>
<a href="controller?command=view&block=1">Show blocked users</a>
<br>
<br>
<br>
<form method="get" action="controller">
    <input type="hidden" name="command" value="logout">
    <input type="submit" value="logout">
</form>




</body>
</html>
