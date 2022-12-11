<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/27/2022
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("id",session.getAttribute("id"));
%>

<form method="get" action="controller">
    <input type="hidden" name="command" value="add_alien">
    <label>
        Alien name: <input type="text" name="alien_name" required>
    </label>
    <label>
        Alien's origin: <input type="text" name="source" required>
    </label>
    <input type="hidden" name="admin_name" value="${id}">
    <label>
        Image: <input type="text" name="image_url" required>
    </label>
    <input type="submit" value="add">
</form>
</body>
</html>
