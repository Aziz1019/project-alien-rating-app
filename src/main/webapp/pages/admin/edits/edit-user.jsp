<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Form</title>
</head>
<body>


<h1>Edit Form</h1>
<table>
    <form action="controller" method="get">
    <input type="hidden" name="command" value="update"/>
        <tr><td>Id:</td><td>
            <input type="text" name="id" value="${currentUser.getId()}"/></td></tr>
        <tr><td>Username:</td><td>
            <input type="text" name="username" value="${currentUser.getUsername()}"/></td></tr>
        <tr><td>Status:</td><td>
            <input type="text" name="status" value="${currentUser.getStatus()}"/></td></tr>
        <tr><td>Password</td><td>
            <input type="password" name="password" value="${currentUser.getPassword()}"/></td></tr>
        <tr><td>Active:</td><td>
            <input type="text" name="active" value="${currentUser.getIsActive()}"/></td></tr>
        <tr><td>Role:</td><td>
            <input type="text" name="role" value="${currentUser.getRole()}"/></td></tr>

        <tr><td colspan="2"><input type="submit" value="Update User"/></td></tr>
    </form>
</table>

</body>
</html>
