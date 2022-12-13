<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="id" scope="session" value='${sessionScope.id}'/>

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
